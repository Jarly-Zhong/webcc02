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
  <script src="/static/js/stu_courlist.js"></script>
</head>
<body>
  <table class="table">
    <thead>
      <th></th>
      <th>课程名称</th>
      <th>开课时间</th>
      <th>课程教师</th>
      <th>已选人数</th>
      <th>最大人数</th>
      <th>操作</th>
      <th></th>
    </thead>
    <tbody>
      <c:forEach items="${courselist}" var="CousrT">
        <tr>
          <td></td>
          <td>${CousrT.courseName}</td>
          <td>${CousrT.courseTime}</td>
          <td>${CousrT.teacherName}</td>
          <td>${CousrT.current_size}</td>
          <td>${CousrT.max_size}</td>
          <td>
            <input type="button" class="btn btn-sm btn-primary setCour" value="选课" >
            <form class="courF">
                <input type="hidden" name="stuid" value="${student.id}">
                <input type="hidden" name="courid" value="${CousrT.courseId}">
            </form>
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
</script>
</html>
