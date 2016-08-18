<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
</head>
<body>
<div class="col-sm-offset-2 col-sm-6">
  <form id="teaF" action="/admin/updatetea.do" method="post" class="form-horizontal" style="text-align: center">
    <input type="hidden" id="teaid" name="id" value="${tea.id}">
    <table class="table table-bordered " STYLE="text-align: center">
      <tr>
        <td>姓名</td>
        <td><input type="text" id="teaname" name="teaname" value="${tea.teaname}"></td>
      </tr>
      <tr>
        <td>学号</td>
        <td>
          <input type="text" id="teano" name="teano" value="${tea.teano}">
        </td>
      </tr>
      <tr>
        <td>性别</td>
        <td>
          <c:choose>
            <c:when test="${tea.teasex==1}">
              <input type="radio" name="teasex" value="1" checked>男 &nbsp;&nbsp;
              <input type="radio" name="teasex" value="0">女
            </c:when>
            <c:when test="${tea.teasex==0}">
              <input type="radio" name="teasex" value="1">男 &nbsp;&nbsp;
              <input type="radio" name="teasex" value="0" checked>女
            </c:when>
          </c:choose>
        </td>
      </tr>
      <tr>
        <td>出生日期:</td>
        <td><input type="text" id="birthday" name="birthday" value="${tea.birthday}"></td>
      </tr>
      <tr>
        <td>手机:</td>
        <td><input type="text" id="tel" name="tel" value="${tea.tel}"></td>
      </tr>
      <tr>
        <td>密码:</td>
        <td><input type="password" id="pwd" name="pwd" value="${tea.pwd}"></td>
      </tr>
    </table>
    <input id="saveBtn" type="button" value="确定修改">
  </form>
</div>
<script>
  $(document).ready(function(){

    $("#saveBtn").click(function(){
      var inp = $("#teaF").find("input");
      for(var i = 0 ; i < inp.size() ; i++){
        var ip = inp.eq(i).val();
        if( ip == '"'){
          alert("输入不能为空!");
          return;
        }
      }
      var msg = $("#teaF").serialize();
      var href = "/admin/updatetea.do";
      console.log(msg);
      console.log(href);
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
</body>
</html>

