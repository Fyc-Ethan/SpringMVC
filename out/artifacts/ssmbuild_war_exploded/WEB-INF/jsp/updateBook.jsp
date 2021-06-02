<%--
  Created by IntelliJ IDEA.
  User: FYC
  Date: 2021/5/29
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改信息</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 引入 Bootstrap -->
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>修改信息</small>
        </h1>
      </div>
    </div>
  </div>
<%--  可以使用restful来实现用一个方法完成多个跳转 前端URL写/book/addBook      /book/updateBook
      后端一个方法接收请求 /book/{id}  用@PathVariable（"id"）取出参数 并返回 return id;
      --%>


<%--  提交请求--%>
  <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

<%--      隐藏真实ID传入后台--%>
    <div class="form-group">
        <input type="hidden" class="form-control" name="bookID" value="${Books.getBookID()}"/>
    </div>
    <div class="form-group">
      <label>书籍名称</label>
      <input type="text" class="form-control" name="bookName" value="${Books.getBookName()}"/>
    </div>
    <div class="form-group">
      <label>书籍数量</label>
      <input type="text" class="form-control" name="bookCounts" value="${Books.getBookCounts()}"/>
    </div>
    <div class="form-group">
      <label>书籍详情</label>
      <input type="text" class="form-control" name="detail" value="${Books.getDetail()}"/>
    </div>
    <div class="form-group">
        <input type="submit" class="form-control" value="修改"/>
    </div>

  </form>

</div>

</body>
</html>