<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="col-sm-offset-3 col-sm-6">
<form id="stuF" method="post" class="form-horizontal" style="text-align: center">
  <input type="hidden" id="adminId" name="id" value="${adm.id}">
  <table class="table table-bordered " STYLE="text-align: center">
    <tr>
      <td>用户名</td>
      <td><input type="text" id="aName" name="aname" value="${adm.aname}"></td>
    </tr>
    <tr>
      <td>密码</td>
      <td>
        <input type="password" id="pwd" name="pwd" value="${adm.pwd}">
      </td>
    </tr>
  </table>
  <input id="saveBtn" type="button" value="提交">
</form>
</div>
</body>
<script>
  $(document).ready(function(){
    $("#saveBtn").click(function(){
      var inp = $("#stuF").find("input");
      for(var i = 0 ; i < inp.size() ; i++){
        var ip = inp.eq(i).val();
        if( ip == '"'){
          alert("输入不能为空!");
          return;
        }
      }
      var msg = $("#stuF").serialize();
      var href = "/admin/updateadm.do";
      $.ajax({
        url: href,
        data:msg,
        type:"post",
        success: function(data){
          if(data=="success"){
            alert("更新成功!");
            location.reload();
          }else{
            alert("更新失败!");
          }
        }
      });
    });
  });
</script>
</html>
