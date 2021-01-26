<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.result.toString().equals('Infinity')}">
    Mẫu số phải khác 0
</c:if>
<c:if test="${!requestScope.result.toString().equals('Infinity')}">
    <%=request.getAttribute("result")%>
</c:if>


</body>
</html>
