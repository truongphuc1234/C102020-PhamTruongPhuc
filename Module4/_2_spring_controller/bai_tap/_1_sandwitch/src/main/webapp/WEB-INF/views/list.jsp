<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Condiments</title>
</head>
<body>
<h1>List Condiments</h1>
<c:forEach items="${condiments}" var="condiment">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>
