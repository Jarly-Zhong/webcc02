<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-10
  Time: 下午4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../wel_stu.jsp"%>
<html>
<head>
</head>
<body>
<table class="table">
  <thead>
  <th></th>
  <th>课程名称</th>
  <th>开课时间</th>
  <th>课程教师</th>
  <th>操作</th>
  <th></th>
  </thead>
  <tbody>
  <c:forEach items="${courselist}" var="StuCourC">
    <tr>
      <td></td>
      <td>${StuCourC.courseName}</td>
      <td>${StuCourC.courseTime}</td>
      <td>${StuCourC.teaname}</td>
      <td>
        <input type="button" value="退课" class="btn btn-primary btn-sm quitBtn">
        <form class="quitF">
          <input type="hidden" name="courid" value="${StuCourC.courseid}">
          <input type="hidden" name="stuid" value="${student.id}">
        </form>
      </td>
      <td></td>
    </tr>
  </c:forEach>
  </tbody>
  <tfoot>
  <tr>
    <td colspan="6"></td>
  </tr>
  </tfoot>
</table>
</body>
<script>

$(document).ready(function(){
  $(".quitBtn").click(function(){
    var quitF = $(this).siblings(".quitF");
    var msg = quitF.serialize();
    var href = "/student/quitCour.do";
    $.ajax({
      url: href,
      data:msg,
      type:"post",
      success: function(data){
        if(data=="success") {
          alert("退课成功!");
          location.reload();
        }else if(data=="open"){
          alert("退课失败,课程已经开课!");
        }
      }
    });
  });
});
</script>
</html>
