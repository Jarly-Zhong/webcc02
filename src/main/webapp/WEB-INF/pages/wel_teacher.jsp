<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-9
  Time: 上午11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
<head>
</head>
<body>
<div style="width: 100%">
  <div class="col-sm-2">
    <h4>您好, ${teacher.teaname}老师!</h4>
  </div>
</div>
  <div class="col-sm-12">
    <ul class="nav nav-tabs">
      <li role="presentation">
        <a href="/teacher/courOpen.htm?teaid=${teacher.id}">申请开课</a></li>
      <li role="presentation">
        <a href="/teacher/courView.htm?teaid=${teacher.id}">查看课程</a></li>
      <li role="presentation">
        <a href="/teacher/setGrade.htm?teaid=${teacher.id}">发布成绩</a></li>
      <li role="presentation">
        <a href="/teacher/infoView.htm?teaid=${teacher.id}">个人信息</a></li>
    </ul>
  </div>
</body>
</html>
