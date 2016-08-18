
<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-16
  Time: 上午1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../wel_stu.jsp"%>
<html>
<head>
	<title></title>
</head>
<body>
<table class="table">
  <thead>
  <th></th>
  <th>课程名称</th>
  <th>课程教师</th>
  <th>考试时间地点</th>
  <th></th>
  </thead>
  <tbody>
  <c:forEach items="${courlist}" var="StuCourC">
    <tr>
      <td></td>
      <td>${StuCourC.courseName}</td>
      <td>${StuCourC.teaname}</td>
      <td>${StuCourC.examTime}</td>
      <td></td>
    </tr>
  </c:forEach>
  </tbody>
  <tfoot>
  <tr>
    <td colspan="5"></td>
  </tr>
  </tfoot>
</table>
</body>
</html>
