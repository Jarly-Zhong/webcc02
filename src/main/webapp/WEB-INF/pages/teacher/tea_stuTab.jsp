
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
    <th>学号</th>
    <th>性别</th>
    <th>电话</th>
  </thead>
  <tbody>
  <c:forEach items="${stuList}" var="Stuuser">
    <tr>
       <td>${Stuuser.stuname}</td>
       <td>${Stuuser.stuno}</td>
       <td>
         <c:choose>
          <c:when test="${Stuuser.stusex==1}">
            男
          </c:when>
           <c:when test="${Stuuser.stusex==0}">
             女
           </c:when>
         </c:choose>
       </td>
       <td>${Stuuser.tel}</td>
    </tr>
  </c:forEach>
  </tbody>
  <tfoot>
  <tr>
    <td colspan="4"></td>
  </tr>
  </tfoot>
</table>
</body>
</html>
