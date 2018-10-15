<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">测试查询</a><br>

<form action="account/saveAccount" method="post">
    姓名:<input type="text" name="name"><br>
    金额:<input type="text" name="money"><br>
    <input type="submit" value="保存">
</form>

<form action="account/transfer" method="post">
    姓名:<input type="text" name="oldAccount"><br>
    姓名:<input type="text" name="newAccount"><br>
    金额:<input type="text" name="money"><br>
    <input type="submit" value="保存">
</form>
<a href="account/initUpdat">initUpdate默认页面</a><br>

<a href="account/textDemo">请求转发</a><br>
<a href="account/textDemo1">请求转发1</a><br>
<a href="account/springForward">SpringMVC_请求转发</a><br>


<a href="account/textDemo01">重定向01</a><br>
<a href="account/textDemo02">重定向02</a><br>
<a href="account/springRedirect">SpringMVC_重定向</a><br>

<a href="account/writeDemo">直接写出</a><br>

<a href="account/findAll01">MedolAndView</a><br>
</body>
</html>
