<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../wel_teacher.jsp"%>
<html>
<head>
</head>
<body>
<table class="table">
  <thead>
    <th></th>
    <th>课程名称</th>
    <th>考试时间和地点</th>
    <th>操作</th>
    <th></th>
  </thead>
  <tbody>
    <tr>
      <td></td>
      <td>${course.courseName}</td>
      <td>
        <form id="eTimeF">
          <input type="hidden" name="courid" value="${course.courseId}">
          <input id="eTime" type="text" value="${course.examTime}" name="eTime">
        </form>
      </td>
      <td>
        <input id="saveEtime" type="button" class="btn btn-primary btn-sm" value="保存">
        <input id="last" type="button" class="btn btn-primary btn-sm" value="返回">
      </td>
      <td></td>
    </tr>
  </tbody>
  <tfoot>
    <td colspan="5"></td>
  </tfoot>
</table>
</body>
<script>
$(document).ready(function(){

  $("#last").click(function(){
    history.go(-1);
  });

  $("#saveEtime").click(function(){
    var etime = $("#eTime").val();
    if(etime.length = 0 || etime=="" ){
      alert("考试时间不能为空");
      return;
    }
    var msg = $("#eTimeF").serialize();
    var href = "/teacher/setETime.do";
    $.ajax({
      url: href,
      data: msg,
      type: "post",
      success: function (data) {
        if (data == "success") {
          alert("保存成功!");
          history.go(-1);
        } else {
          alert("保存失败!");
        }
      }
    });
  });
});
</script>
</html>
