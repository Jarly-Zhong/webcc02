<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-9
  Time: 上午11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
<head>
</head>
<body>
  <div class="col-sm-2">
    <h4>你好, ${student.stuname}同学!</h4>
  </div>
  <div class="col-sm-12">
      <ul class="nav nav-tabs">
        <li role="presentation">
          <a href="/student/courlist.htm?stuid=${student.id}">学生选课</a></li>
        <li role="presentation">
          <a href="/student/courSet.htm?stuid=${student.id}">已选课程</a></li>
        <li role="presentation">
          <a href="/student/examView.htm?stuid=${student.id}">考试时间</a></li>
        <li role="presentation">
          <a href="/student/gardeView.htm?stuid=${student.id}">查看成绩</a></li>
        <li role="presentation">
          <a href="/student/infoView.htm?stuid=${student.id}">个人信息</a></li>
      </ul>
  </div>
  <%-- star 正文内容--%>
  <div>
    <iframe style="height: 100%;width: 100%;" src=""></iframe>
  </div>
  <%-- end 正文内容--%>

</body>
</html>
