<%--
  Created by IntelliJ IDEA.
  User: FYC
  Date: 2021/5/29
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <style>
      a{
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h3{
        width: 180px;
        height: 30px;
        margin: 100px auto;
        text-align: center;
        line-height: 30px;
        background: cornflowerblue;
        border-radius: 10px;
      }
    </style>
  </head>
  <body>
    <h3>
      <!--首页跳转连接-->
      <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>
    </h3>
  </body>
</html>
