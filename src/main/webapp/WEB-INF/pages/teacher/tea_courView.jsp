<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-10
  Time: 下午11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../wel_teacher.jsp"%>
<html>
<head>
</head>
<body>
<table class="table">
  <thead>
  <th></th>
  <th>课程名称</th>
  <th>开课时间</th>
  <th>已选人数</th>
  <th>最大人数</th>
  <th>课程状态</th>
  <th>操作</th>
  <th></th>
  </thead>
  <tbody>
  <c:forEach items="${courlist}" var="Course">
    <tr>
      <td></td>
      <td>${Course.courseName}</td>
      <td>${Course.courseTime}</td>
      <td>${Course.current_size}</td>
      <td>${Course.max_size}</td>
      <td>
        <c:choose>
          <c:when test="${Course.status==0}">
            审核中...
          </c:when>
          <c:when test="${Course.status==1}">
            选课中
          </c:when>
          <c:when test="${Course.status==2}">
            开课中
          </c:when>
          <c:when test="${Course.status==3}">
            已结课
          </c:when>
          <c:when test="${Course.status==4}">
            已出成绩
          </c:when>
        </c:choose>
      </td>
      <td>
        <a href="/teacher/courStu.htm?courid=${Course.courseId}&teaid=${teacher.id}">学生表</a> &nbsp;&nbsp;
        <c:choose>
          <c:when test="${Course.status==2}">
            <a id="endCour" courid="${Course.courseId}">结课</a>
          </c:when>
          <c:when test="${Course.status==3}">
            <a href="/teacher/setETime.htm?courid=${Course.courseId}&teaid=${teacher.id}">考试时间</a>
          </c:when>
          <c:when test="${Course.status==4}">
            <a href="/teacher/viewGrade.htm?courid=${Course.courseId}&teaid=${teacher.id}">查看成绩</a>
          </c:when>
        </c:choose>
      </td>
      <td></td>
    </tr>
  </c:forEach>
  </tbody>
  <tfoot>
  <tr>
    <td colspan="8"></td>
  </tr>
  </tfoot>
</table>
</body>
<script>
  $(document).ready(function(){
    $("#endCour").click(function(){
      var courid = $(this).attr("courid");
      var msg =  "courid=" + courid ;
      var href= "/teacher/endCour.do";
      $.ajax({
        url: href,
        data:msg,
        type:"post",
        success: function(data){
          if(data=="success"){
            alert("结课成功!");
            location.reload();
          }else{
            alert("结课失败!");
          }
        }
      });
    });
  });
</script>
</html>
