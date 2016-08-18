
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_admin.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="col-sm-offset-2 col-sm-6">
  <form action="#" method="post" class="form-horizontal" style="text-align: center">
    <table class="table table-bordered " STYLE="text-align: center">
      <tr>
        <td>课程名称</td>
        <td><input type="text" id="courseName" name="courseName" ></td>
      </tr>
      <tr>
        <td>上课时间</td>
        <td>
          <input type="text" id="courseTime" name="courseTime" >
        </td>
      </tr>
      <tr>
        <td>教师</td>
        <td>
          <input type="text" id="teacherName" name="teacherName">
        </td>
      </tr>
      <tr>
        <td>已选人数</td>
        <td>
          <input type="text" id="currentSize" name="currentSize">
        </td>
      </tr>
      <tr>
        <td>最大人数</td>
        <td>
          <input type="text" id="maxSize" name="maxSize">
        </td>
      </tr>
      <tr>
        <td>课程状态</td>
        <td>
            <input type="radio" name="status" value="0" checked> 申请开课 &nbsp;&nbsp;
            <input type="radio" name="status" value="1" > 选课中 &nbsp;&nbsp;
            <input type="radio" name="status" value="2" > 开课中 &nbsp;&nbsp;
            <input type="radio" name="status" value="3" > 已结课 &nbsp;&nbsp;
            <input type="radio" name="status" value="3"> 已结课 &nbsp;&nbsp;
        </td>
      </tr>
    </table>
    <input type="submit" value="提交">
  </form>
</div>
</body>
</html>
