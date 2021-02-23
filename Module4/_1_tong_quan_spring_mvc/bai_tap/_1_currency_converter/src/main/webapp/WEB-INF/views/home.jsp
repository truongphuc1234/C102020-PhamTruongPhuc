<%--
  Created by IntelliJ IDEA.
  User: phuc
  Date: 22/02/2021
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chương trình chuyển đổi tiền tệ</h1>
<form method="post" action="/converter">
    <label>USD: </label>
    <input name="usd" type="number"/>
    <label>Rate: </label>
    <input name="rate" type="number"/>
    <input type="submit" value="Convert"/>
</form>
</body>
</html>
