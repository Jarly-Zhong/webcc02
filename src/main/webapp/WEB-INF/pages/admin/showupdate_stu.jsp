<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="col-sm-offset-2 col-sm-6">
<form id="stuF" action="/admin/updatestu.do" method="post" class="form-horizontal" style="text-align: center">
  <input type="hidden" id="admId" name="admId" value="${admin.id}">
  <input type="hidden" id="stuid" name="id" value="${stu.id}">
  <%--<input type="hidden" id="pwd" name="pwd" value="${stu.pwd}">--%>
  <table class="table table-bordered " STYLE="text-align: center">
    <tr>
      <td>姓名</td>
      <td><input type="text" id="stuname" name="stuname" value="${stu.stuname}"></td>
    </tr>
    <tr>
      <td>学号</td>
      <td>
        <input type="text" id="stuno" name="stuno" value="${stu.stuno}">
      </td>
    </tr>
    <tr>
      <td>性别</td>
      <td>
        <c:choose>
          <c:when test="${stu.stusex==1}">
            <input type="radio" name="stusex" value="1" checked>男 &nbsp;&nbsp;
            <input type="radio" name="stusex" value="0">女
          </c:when>
          <c:when test="${stu.stusex==0}">
            <input type="radio" name="stusex" value="1">男 &nbsp;&nbsp;
            <input type="radio" name="stusex" value="0" checked>女
          </c:when>
        </c:choose>
      </td>
    </tr>
    <tr>
      <td>出生日期:</td>
      <td><input type="text" id="birthday" name="birthday" value="${stu.birthday}"></td>
    </tr>
    <tr>
      <td>手机:</td>
      <td><input type="text" id="tel" name="tel" value="${stu.tel}" maxlength="11"></td>
    </tr>
    <tr>
      <td>密码:</td>
      <td><input type="password" id="pwd" name="pwd" value="${stu.pwd}"></td>
    </tr>
  </table>
  <input id="saveBtn" type="button" value="确定修改">
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
      var href = "/admin/updatestu.do";
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
