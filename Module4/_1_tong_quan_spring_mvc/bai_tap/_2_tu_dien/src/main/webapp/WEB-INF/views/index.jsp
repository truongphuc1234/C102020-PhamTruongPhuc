<%--
  Created by IntelliJ IDEA.
  User: phuc
  Date: 22/02/2021
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Từ điển Việt Anh</h1>
<form action="/search" method="post">
    <label> Nhập từ cần tra: </label>
    <input type="text" name="word"/>
    <input type="submit" value="Tra cứu"/>
</form>
</body>
</html>
