<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/14 0014
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">查询所有</a><br>
<a href="account/testDemo">测试方法</a><br>

<form action="account/findOne" method="post">
    请输入姓名 <input type="text" name="username"><br>
    <input type="submit" name="查询"><br>
</form>
</body>
</html>
