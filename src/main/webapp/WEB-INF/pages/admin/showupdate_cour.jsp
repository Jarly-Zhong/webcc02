<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="col-sm-offset-2 col-sm-6">
  <form id="courF" action="/admin/updatecour.do" method="post" class="form-horizontal" style="text-align: center">
    <input type="hidden" id="courid" name="courid" value="${course.courseId}">
    <table class="table table-bordered " STYLE="text-align: center">
      <tr>
        <td>课程名称</td>
        <td><input type="text" id="courseName" name="courseName" value="${course.courseName}"></td>
      </tr>
      <tr>
        <td>上课时间</td>
        <td>
          <input type="text" id="courseTime" name="courseTime" value="${course.courseTime}">
        </td>
      </tr>
      <tr>
        <td>教师</td>
        <td>
          ${course.teacherName}
        </td>
      </tr>
      <tr>
        <td>已选人数</td>
        <td>
          <input type="text" id="currentSize" name="currentSize" value="${course.current_size}">
        </td>
      </tr>
      <tr>
        <td>最大人数</td>
        <td>
          <input type="text" id="maxSize" name="maxSize" value="${course.max_size}">
        </td>
      </tr>
      <tr>
        <td>课程状态</td>
        <td>
          <c:choose>
            <c:when test="${course.status==0}">
              <input type="radio" id="status" name="status" value="0" checked> 申请开课
            </c:when>
            <c:otherwise>
              <input type="radio" id="status" name="status" value="0"> 申请开课
            </c:otherwise>
          </c:choose>
          <c:choose>
            <c:when test="${course.status==1}">
              <input type="radio" id="status" name="status" value="1" checked> 选课中
            </c:when>
            <c:otherwise>
              <input type="radio" id="status" name="status" value="1"> 选课中
            </c:otherwise>
          </c:choose>
          <c:choose>
            <c:when test="${course.status==2}">
              <input type="radio" id="statu" name="status" value="2" checked> 开课中
            </c:when>
            <c:otherwise>
              <input type="radio" id="statu" name="status" value="2"> 开课中
            </c:otherwise>
          </c:choose>
          <c:choose>
            <c:when test="${course.status==3}">
              <input type="radio" id="status" name="status" value="3" checked> 已结课
            </c:when>
            <c:otherwise>
              <input type="radio" id="status" name="status" value="3"> 已结课
            </c:otherwise>
          </c:choose>
          <c:choose>
            <c:when test="${course.status==4}">
              <input type="radio" id="status" name="status" value="3" checked> 已出成绩
            </c:when>
            <c:otherwise>
              <input type="radio" id="status" name="status" value="3"> 已出成绩
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </table>
    <input id="saveBtn" type="button" value="确定修改">
  </form>
</div>
</body>

<script>
  $(document).ready(function(){

    $("input").blur(function () {
      $("input").blur(function(){
        var i = $(this).val();
        if(i==""){
          alert("输入不能为空!")
        }
      });
    });

    $("#saveBtn").click(function(){
      var inp = $("#courF").find("input");
      for(var i = 0 ; i < inp.size() ; i++){
        var ip = inp.eq(i).val();
        if( ip=="" || null==ip ){
          alert("输入不能为空!");
          return;
        }
      }
      var msg = $("#courF").serialize();
      var href = "/admin/updatecour.do";
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
