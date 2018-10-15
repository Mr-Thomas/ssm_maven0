<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/13 0013
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询所有</h3>
<c:forEach items="#{aaa}" var="account" >
    ${account.name}
    ${account.money}
    ${account.id}
</c:forEach>
</body>
</html>
