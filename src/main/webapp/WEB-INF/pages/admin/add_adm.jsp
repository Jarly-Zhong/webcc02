
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="col-sm-offset-3 col-sm-6" style="text-align: center;">
  <form action="/admin/addadm.do?admId=${admin.id}" method="post" class="form-horizontal">
    <table class="table table-bordered" style="text-align: center">
      <thead>
      <th></th>
      <th>添加管理员信息</th>
      </thead>
      <tr>
        <td>姓名</td>
        <td><input type="text" id="aName" name="aName" placeholder="请输入管理员名称"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" id="pwd" name="pwd" placeholder="请输入密码" ></td>
      </tr>
    </table>
    <input type="submit" value="确定添加">
  </form>
</div>
</body>
<script>
  $(document).ready(function () {
    $("input").blur(function(){
      var i = $(this).val();
      if(i==""){
        alert("输入不能为空!")
      }
    });
  });
</script>
</html>
