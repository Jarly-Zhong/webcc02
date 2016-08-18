
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../wel_teacher.jsp"%>
<html>
<head>

</head>
<body>
<form class="form-horizontal" id="infoF">
  <input type="hidden" value="${teacher.id}" name="teaid">
  <div class="col-sm-offset-3 col-sm-6" style="text-align:center">
    <table class="table table-bordered" style="margin: auto;text-align: center">
      <tbody>
      <tr>
        <td class="col-sm-offset-2">姓名</td>
        <td>${teacher.teaname}</td>
      </tr>

      <tr>
        <td class="col-sm-offset-2">工号</td>
        <td>${teacher.teano}</td>
      </tr>

      <tr>
        <td class="col-sm-offset-2">性别</td>
        <td>
          <div class="radio">
            <label>
              <c:choose>
                <c:when test="${teacher.teasex==1}">
                  <input id="teasex" value="1" name="teasex" type="radio" checked>男
                </c:when>
                <c:otherwise >
                  <input id="teasex" value="1" name="teasex" type="radio">男
                </c:otherwise>
              </c:choose>
            </label>
            <label>
              <c:choose>
                <c:when test="${teacher.teasex==0}">
                  <input id="teasex" value="0" name="teasex" type="radio" checked>女
                </c:when>
                <c:otherwise >
                  <input id="teasex" value="0" name="teasex" type="radio">女
                </c:otherwise>
              </c:choose>
            </label>
          </div>
        </td>
      </tr>

      <tr>
        <td class="col-sm-offset-2">电话</td>
        <td>
          <input id="teatel" class="form-group" type="text" name="teatel" value="${teacher.tel}" maxlength="11">
        </td>
      </tr>

      <tr>
        <td>生日</td>
        <td>
          <input id="teabir" class="form-group" type="text" name="teabir" value="${teacher.birthday}">
        </td>
      </tr>
      </tbody>
    </table>
    <div>
      <input class="form-group btn btn-primary" value="保存" id="savaInfo">
    </div>
  </div>

</form>
</body>
<script>

  $(document).ready(function(){

    $("#teatel").blur(function() {
    var telN = $(this).val();
    if (telN.length != 11) {
      $(this).val("13900000000");
      alert("请输入11位手机号码");
    }
  });

  $("#savaInfo").click(function(){
    var teatel = $("#teatel").val();
    var teabir = $("#teabir").val();
    if(teatel.length != 11){
      $("#teatel").val("13900000000");
      alert("电话格式不正确");
      return;
    }
    if(teabir.length < 1){
      $("#teabir").val("1990-01-01");
      alert("生日不能为空");
      return;
    }
    var msg =  $("#infoF").serialize();
    var href = "/teacher/saveInfo.do";
    $.ajax({
      url: href,
      data:msg,
      type:"post",
      success: function(data){
        if(data=="success"){
          alert("保存成功!");
          location.reload();
        }else{
          alert("保存失败!");
        }
      }
    });
  });
  });
</script>
</html>
