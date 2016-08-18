<%--
  Created by IntelliJ IDEA.
  User: zhong
  Date: 16-6-15
  Time: 下午9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form class="form-horizontal">
  <table class="table">
    <thead>
      <th></th>
      <th>ID</th>
      <th>名字</th>
      <th>操作</th>
    </thead>
    <tbody>
    <c:forEach var="adm" items="${adminList}">
    <tr>
      <td></td>
      <td>${adm.id}</td>
      <td>${adm.aname}</td>
      <td>
        <a href="/admin/showupdateadm.do?adm=${adm.id}&admId=${admin.id}">编辑</a>
        <a class="del" adm="${adm.id}" href="">删除</a></td>
      </td>
    </tr>
    </c:forEach>
    </tbody>
    <tfoot>
      <td colspan="4">
      </td>
    </tfoot>
  </table>
</form>
<a href="/admin/showaddadm.do?admId=${admin.id}" ><input type="button" class="btn" value="添加管理员"/></a>&nbsp;
<a href="/admin/returnadmin.do" ><input type="button" id="returnadmin" class="btn" value="返回首页"/></a>
</body><script>
  $(document).ready(function(){
    $(".del").click(function(){
      var adm = $(this).attr("adm");
      var href = "/admin/deleteadm.do";
      var msg = "adm=" + adm ;
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
