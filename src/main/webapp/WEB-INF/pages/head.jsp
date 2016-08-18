<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%String path = request.getContextPath();%>
    <link  type="text/css" rel="stylesheet"
         href="<%=path %>/static/bootstrap-3.3.6-dist/css/bootstrap.min.css">
  <script type="text/javascript" src="<%=path %>/static/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="<%=path %>/static/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" style="background-color:skyblue">
    <div class="container col-sm-offset-1 col-sm-6" style="background-color:skyblue">
        <h4 style="color: white">燕山大学在线选课系统</h4>
    </div>
    <div class="pull-right" style="background-color:skyblue">
        <a href="/index">用户注销</a>
    </div>
</nav>
</body>
</html>