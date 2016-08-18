
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../wel_teacher.jsp"%>
<html>
<head>
  <script src="/static/js/tea_courOpen.js"></script>
</head>
<body>
  <form id="courFrom" class="form-horizontal" method="post" action="/teacher/courOpen.do">
    <input type="hidden" name="teaid" value="${teacher.id}">
    <div class="col-sm-offset-3 col-sm-6" style="text-align:center">
      <table class="table table-bordered" style="margin: auto;text-align:center">
        <tr>
          <td>课程名称</td>
          <td><input name="courName" class="form-group"
                     placeholder="请输入课程名称" type="text"></td>
        </tr>
        <tr>
          <td>开课时间</td>
          <td><input name="courTime" class="form-group"
                     placeholder="请输入课程时间" type="text"></td>
        </tr>
        <tr>
          <td>学生人数</td>
          <td><input name="maxSize" class="form-group"
                     placeholder="请输入学生人数" type="text"></td>
        </tr>
      </table>
      <div>
        <input type="button" class="form-group btn-primary" id="submit" value="申请开课">
      </div>
    </div>
  </form>
</body>
</html>
