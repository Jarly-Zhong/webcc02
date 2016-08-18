<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../wel_teacher.jsp"%>
<html>
<head>
</head>
<body>
<table class="table">
  <thead>
    <th>学生姓名</th>
    <th>课程名称</th>
    <th>分数</th>
  </thead>
  <tbody>
    <c:forEach items="${stuSList}" var="StuS">
      <tr>
        <td>${StuS.stuName}</td>
        <td>${StuS.courName}</td>
        <td>${StuS.score}</td>
      </tr>
    </c:forEach>
  </tbody>
  <tfoot>
  <tr>
    <td colspan="3"></td>
  </tr>
  </tfoot>
</table>
</body>
</html>
