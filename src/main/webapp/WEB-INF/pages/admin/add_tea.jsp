<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="col-sm-offset-3 col-sm-6" style="text-align: center;">
  <form action="/admin/addtea.do?admId=${admin.id}" method="post" class="form-horizontal">
    <table class="table table-bordered" style="text-align: center">
      <thead>
      <th></th>
      <th>添加教师信息</th>
      </thead>
      <tr>
        <td>姓名</td>
        <td><input type="text" id="teaname" name="teaname" value=""></td>
      </tr>
      <tr>
        <td>工号</td>
        <td><input type="text" id="teano" name="teano" value=""></td>
      </tr>
      <tr>
        <td>性别</td>
        <td><input type="radio" name="teasex" value="1">男 &nbsp;&nbsp;
          <input type="radio" name="teasex" value="0">女</td>
      </tr>
      <tr>
        <td>出生日期</td>
        <td><input type="text" id="teabir" name="teabir"></td>
      </tr>
      <tr>
        <td>手机</td>
        <td><input type="text" id="teatel" name="teatel"></td>
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