<%--
  Created by IntelliJ IDEA.
  User: intec
  Date: 03/12/2019
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>${message}</p>

<c:if test="${name eq null}">
<p>may I know your name?</p>
<form action="session" method="post">
    <input type="text" name="name">
    <input type="submit" value="enter">
</form>
</c:if>
</body>
</html>
