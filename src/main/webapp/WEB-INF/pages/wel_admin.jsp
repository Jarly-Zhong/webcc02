<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
<head>
  <script type="application/javascript" src="<%=path%>/static/js/wel_admin.js"></script>
</head>
<body>
<div class="col-sm-2">
  <h4>你好, ${admin.aname}管理员!</h4>
</div>
<div class="col-sm-12">
  <ul class="nav nav-tabs">
    <li role="presentation">
      <a href="/admin/adminstu.do?admid=${admin.id}">学生管理</a>
    <li role="presentation">
      <a href="/admin/admintea.do?admid=${admin.id}" >教师管理</a>
    <li role="presentation">
      <a href="/admin/adminadmin.do?admid=${admin.id}" >管理员管理</a>
    <li role="presentation">
      <a href="/admin/admincourse.do?admid=${admin.id}">课程管理</a>
  </ul>
</div>
<div>
  <iframe style="height: 100%;width: 100%;" src=""></iframe>
</div>
</body>
</html>