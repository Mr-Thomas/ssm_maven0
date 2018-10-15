<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/8 0008
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有账户成功</h3>
    <c:forEach items="${listt}" var="account">
        ${account.name}
        ${account.money}
        ${account.id}
    </c:forEach>
</body>
</html>
