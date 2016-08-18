<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-16
  Time: 上午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../wel_teacher.jsp"%>

<html>
<head>
	<title></title>
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
        </c:choose>
      </td>
      <td><a href="/teacher/setGrade.do?teaid=${teacher.id}&courid=${Course.courseId}">公布成绩</a></td>
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
</html>
