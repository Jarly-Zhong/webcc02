<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-10
  Time: 下午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
</head>
<body>
<table  class="table">
  <%--course_id, course_name, course_time, teacherid,status,CURRENT_size,max_size--%>
  <thead>
    <th>课程编号</th>
    <th>课程名称</th>
    <th>上课时间</th>
    <th>授课老师</th>
    <th>课程状态</th>
    <th>上课人数</th>
    <th>最大人数</th>
    <th>操作</th>
  </thead>
  <c:forEach var="cousrT" items="${courseList}">
    <tr>
      <td>${cousrT.courseId}</td>
      <td>${cousrT.courseName}</td>
      <td>
          ${cousrT.courseTime}
      </td>
      <td>${cousrT.teacherName}</td>
      <td>
        <c:choose>
          <c:when test="${cousrT.status==0}">
            <a class="openC" courid="${cousrT.courseId}" href="">同意开课</a>
          </c:when>
          <c:when test="${cousrT.status==1}">
            选课中
          </c:when>
          <c:when test="${cousrT.status==2}">
            开课中
          </c:when>
          <c:when test="${cousrT.status==3}">
            已结课
          </c:when>
        </c:choose>
      </td>
      <td>${cousrT.current_size}</td>
      <td>${cousrT.max_size}</td>
      <td><a href="/admin/showupdatecourse.do?courid=${cousrT.courseId}&admId=${admin.id}">修改</a>&nbsp;&nbsp;
        <a class="del" courid="${cousrT.courseId}" href="">删除</a>
      </td>
    </tr>
  </c:forEach>
  <tfoot>
    <tr>
      <td colspan="8"></td>
    </tr>
  </tfoot>
</table>
<a href="/admin/showaddcour.do?admId=${admin.id}" ><input type="button" class="btn" value="添加课程"/></a>&nbsp;
<a href="/admin/returnadmin.do" ><input type="button" id="returnadmin" class="btn" value="返回首页"/></a>
</body>
<script>
$(document).ready(function(){
  $(".openC").click(function(){
    var courid = $(this).attr("courid");
    var href = "/admin/agreeCour.do";
    var msg = "courid=" + courid ;
    console.log(href);
    console.log(msg);
    $.ajax({
      url: href,
      data:msg,
      type:"post",
      success: function(data){
        if(data=="success"){
          alert("开课成功!");
          location.reload();
        }else{
          alert("开课失败!");
        }
      }
    });
  });

  $(".del").click(function(){
    var courid = $(this).attr("courid");
    var href = "/admin/deletecourse.do";
    var msg = "courid=" + courid ;
    console.log(href);
    console.log(msg);
    $.ajax({
      url: href,
      data:msg,
      type:"post",
      success: function(data){
        if(data=="success"){
          alert("删除成功!");
          location.reload();
        }else{
          alert("删除失败!");
        }
      }
    });
  });

});

</script>
</html>
