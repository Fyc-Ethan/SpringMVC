<%--
  Created by IntelliJ IDEA.
  User: FYC
  Date: 2021/5/29
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
            <small>新增书籍</small>
          </h1>
        </div>
      </div>
    </div>


    <form action="${pageContext.request.contextPath}/book/addtheBook" method="post">
      <div class="form-group">
        <label>书籍名称</label>
<%--        <!--required 表单写完才能提交，数据校验（后端验证，前端验证不安全）-->--%>
        <input type="text" class="form-control" name="bookName" required>
      </div>
      <div class="form-group">
        <label>书籍数量</label>
        <%-- name 属性用于对提交到服务器后的表单数据进行标识，或者在客户端通过 JavaScript 引用表单数据。--%>
        <%--        只有设置了 name 属性的表单元素才能在提交表单时传递它们的值--%>
        <%--        name的值要和pojo对应，如果不对应则后台数据接收不到--%>
        <%--name="bookCounts"   addBook=>Books{bookID=0, bookName='Java入门3', bookCounts=111, detail='good'}
          name="bookCount"   addBook=>Books{bookID=0, bookName='Java入门3111', bookCounts=0, detail='good'}
          --%>
        <input type="text" class="form-control" name="bookCounts" required>
      </div>
      <div class="form-group">
        <label>书籍详情</label>
        <input type="text" class="form-control" name="detail" required>
      </div>
      <div class="form-group">
        <input type="submit" class="form-control" value="添加">
      </div>


    </form>

  </div>

</body>
</html>
