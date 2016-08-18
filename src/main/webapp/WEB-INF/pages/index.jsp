<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp"%>
<html>
<style>
  body {
    background-image:url("../../static/YSU_1366.png");
  }
</style>
<body>
<div style="z-index:-1;width: 100%;height: 100%" id="bg" >
<div style="z-index:0;" >
  <div class="col-sm-offset-3 col-sm-6" style="z-index:10; " >
  <form class="form-horizontal" role="form" action="/index/login.do" method="post">
    <div class="form-group">
      <label for="userName" class="col-sm-4 control-label">用户名</label>
      <div class="col-sm-4" >
        <input type="text" class="form-control" name="userName" id="userName"
               placeholder="请输入用户名">
      </div>
    </div>

    <div class="form-group">
      <label for="passWord" class="col-sm-4 control-label">密码</label>
      <div class="col-sm-4">
        <input type="password" class="form-control" name="passWord" id="passWord"
               placeholder="请输入密码">
      </div>
    </div>

    <div class="form-group">
      <div class="radio col-sm-offset-4 col-sm-4">
        <label>
          <input type="radio" name="opR" value="student" checked> 学生
        </label>

        <label>
          <input type="radio" name="opR" value="teacher"> 教师
        </label>

        <label>
          <input type="radio" name="opR" value="admin"> 管理员
        </label>
      </div>
    </div>

    <div class="form-group">
      <div class="col-sm-offset-4 col-sm-4">
        <button type="submit" class="btn btn-default">登录</button>
      </div>
    </div>
  </form>
  </div>
</div>
</div>
</body>
</html>
