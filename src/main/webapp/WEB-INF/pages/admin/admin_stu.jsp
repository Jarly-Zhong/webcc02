
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<table  class="table">
  <thead>
    <th>姓名</th>
    <th>学号</th>
    <th>性别</th>
    <th>出生日期</th>
    <th>手机</th>
    <th>操作</th>
  </thead>
  <c:forEach var="stu" items="${stuList}">
    <%--id,stuname,stuno,stusex,birthday,tel,pwd--%>
  <tr>
    <td>${stu.stuname}</td>
    <td>${stu.stuno}</td>
    <td>
      <c:choose>
      <c:when test="${stu.stusex==1}">
        男
      </c:when>
      <c:when test="${stu.stusex==0}">
        女
      </c:when>
      </c:choose>
    </td>
    <td>${stu.birthday}</td>
    <td>${stu.tel}</td>
    <td><a href="/admin/showupdatestu.do?stuid=${stu.id}&admId=${admin.id}">修改</a>&nbsp;&nbsp;
      <a class="del" stuid="${stu.id}" href="" >删除</a></td>
  </tr>
  </c:forEach>
  <tfoot>
  <td colspan="6"></td>
  </tfoot>
</table>
<a href="/admin/showaddstu.do?admId=${admin.id}" ><input type="button" id="btn_addstu" class="btn" value="添加学生"/></a>&nbsp;
<a href="/admin/returnadmin.do" ><input type="button" id="returnadmin" class="btn" value="返回首页"/></a>
</body>
<script>
  $(document).ready(function(){
    $(".del").click(function(){
      var stuid = $(this).attr("stuid");
      var href = "/admin/deletestu.do";
      var msg = "stuid=" + stuid ;
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
