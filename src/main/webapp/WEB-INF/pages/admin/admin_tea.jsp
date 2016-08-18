<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-10
  Time: 下午10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
</head>
<body>
<table  class="table">
  <%--`tb_teauser`.`teaName`,--%>
  <%--`tb_teauser`.`teaNo`,--%>
  <%--`tb_teauser`.`teaSex`,--%>
  <%--`tb_teauser`.`birthday`,--%>
  <%--`tb_teauser`.`tel`,--%>
  <%--`tb_teauser`.`pwd`--%>
  <tr>
    <th>姓名</th>
    <th>教工号</th>
    <th>性别</th>
    <th>出生日期</th>
    <th>手机</th>
    <th>操作</th>
  </tr>
  <c:forEach var="tea" items="${teaList}">
    <tr>
      <td>${tea.teaname}</td>
      <td>${tea.teano}</td>
      <td>
        <c:choose>
          <c:when test="${tea.teasex==1}">
            男
          </c:when>
          <c:when test="${tea.teasex==0}">
            女
          </c:when>
        </c:choose>
      </td>
      <td>${tea.birthday}</td>
      <td>${tea.tel}</td>
      <th><a href="/admin/showupdatetea.do?teaid=${tea.id}&admId=${admin.id}">修改</a>&nbsp;&nbsp;
        <a class="del" teaid="${tea.id}" href="">删除</a></td>
    </tr>
  </c:forEach>
</table>
<a href="/admin/showaddtea.do?admId=${admin.id}" ><input type="button" id="btn_addtea" class="btn" value="添加老师"/></a>&nbsp;
<a href="/admin/returnadmin.do" ><input type="button" id="returnadmin" class="btn" value="返回首页"/></a>
</body>
<script>
  $(document).ready(function(){
    $(".del").click(function(){
      var teaid = $(this).attr("teaid");
      var href = "/admin/deletetea.do";
      var msg = "teaid=" + teaid ;
      console.log(href);
      console.log(msg);
      $.ajax({
        url: href,
        data:msg,
        type:"post",
        success: function(data){
          if(data=="success"){
            alert("删除成功!");
            location.reload();
          }else{
            alert("删除失败!");
          }
        }
      });
    });
  });
</script>
</html>
