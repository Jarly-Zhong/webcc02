<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../wel_teacher.jsp"%>
<html>
<head>
</head>
<body>
<form class="form-horizontal" id="gradeF">
  <table class="table">
    <thead>
      <th></th>
      <th>学生姓名</th>
      <th>学号</th>
      <th>分数</th>
      <th></th>
    </thead>
    <tbody>
      <c:forEach items="${stuList}" var="Stuuser">
        <tr>
          <td></td>
          <td>${Stuuser.stuname}</td>
          <td>${Stuuser.stuno}</td>
          <td>
            <input class="gradeI" name="grade" placeholder="请输入学生成绩" maxlength="3"
                   onkeyup="this.value=this.value.replace(/\D/g,'')">
            <input type="hidden" name="stuid" value="${Stuuser.id}">
            <input type="hidden" name="courid" value="${courid}">
          </td>
          <td></td>
        </tr>
      </c:forEach>
    </tbody>
    <tfoot>
      <tr>
        <td colspan="5"></td>
      </tr>
    </tfoot>
  </table>
</form>
<div class="col-sm-offset-4">
  <input type="button" value="保存成绩" class="btn btn-sm btn-primary" id="saveGrade">
  <input type="button" value="返回" class="btn btn-sm btn-primary" id="last">

</div>
</body>
<script>
  $(document).ready(function(){

    $("#last").click(function(){
      history.go(-1);
    });

    $("#saveGrade").click(function(){
      alert("click");
      var gradeI  = $("#gradeF").find(".gradeI");
      for(var i=0 ; i < gradeI.size();i++){
        var grade = gradeI.eq(i).val();
        console.log(grade);
        if(grade > 100 ) {
          alert("请输入小于100的数字!");
          return;
        }
        if(grade=="" || grade==null){
          alert("成绩不能为空!");
          return;
        }
      }
      var msg = $("#gradeF").serialize();
      var href = "/teacher/saveGrade.do";
      $.ajax({
        url: href,
        data:msg,
        type:"post",
        success: function(data){
          if(data=="success"){
            alert("保存成功!");
            history.go(-1);
          }else{
            alert("保存失败!");
          }
        }
      });
    });
  });
</script>
</html>
