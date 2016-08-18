<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-10
  Time: 下午9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../wel_stu.jsp"%>
<html>
<head>

</head>
<body>
    <form class="form-horizontal" id="infoF">
      <div class="col-sm-offset-3 col-sm-6" style="text-align:center">
        <input type="hidden" name="stuid" value="${stuinfo.id}">
        <table class="table table-bordered" style="margin: auto;text-align:center">
          <tbody>
            <tr>
              <td class="col-sm-offset-2">姓名</td>
              <td>${stuinfo.stuname}</td>
            </tr>

            <tr>
              <td class="col-sm-offset-2">学号</td>
              <td>${stuinfo.stuno}</td>
            </tr>

            <tr>
              <td class="col-sm-offset-2">性别</td>
              <td>
                <div class="radio">
                  <label>
                    <c:choose>
                    <c:when test="${stuinfo.stusex==1}">
                      <input id="stusex" value="1" name="stusex" type="radio" checked>男
                    </c:when>
                    <c:otherwise >
                      <input id="stusex" value="1" name="stusex" type="radio">男
                    </c:otherwise>
                    </c:choose>
                  </label>
                  <label>
                    <c:choose>
                    <c:when test="${stuinfo.stusex==0}">
                      <input id="stusex" value="0" name="stusex" type="radio" checked>女
                    </c:when>
                    <c:otherwise >
                      <input id="stusex" value="0" name="stusex" type="radio">女
                    </c:otherwise>
                    </c:choose>
                  </label>
                </div>
              </td>
            </tr>

            <tr>
              <td class="col-sm-offset-2">电话</td>
              <td>
                <input id="stutel" class="form-group" type="text" name="stutel" value="${stuinfo.tel}" maxlength="11">
              </td>
            </tr>

            <tr>
              <td>生日</td>
              <td>
                <input id="stubir" class="form-group" type="text" name="stubir" value="${stuinfo.birthday}">
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

  $("#stutel").blur(function() {
    var telN = $(this).val();
    if (telN.length != 11) {
      $(this).val("13900000000");
      alert("请输入11位手机号码");
    }
  });

  $("#savaInfo").click(function(){
    var stutel = $("#stutel").val();
    var stubir = $("#stubir").val();
    if(stutel.length != 11){
      $("#stutel").val("13900000000");
      alert("电话格式不正确");
      return;
    }
    if(stubir.length < 1){
      $("#stubir").val("1990-01-01");
      alert("生日不能为空");
      return;
    }
    var msg =  $("#infoF").serialize();
    var href = "/student/saveGrade.do";
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
