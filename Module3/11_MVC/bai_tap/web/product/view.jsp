<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Detail Product</title>
</head>
<body>
<h2>View Detail Product</h2>
<a href="/products">Back to product list</a>

<table>
    <tr>
        <td>Id:</td>
        <td>${requestScope['product'].getId()}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${requestScope['product'].getName()}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${requestScope['product'].getPrice()}</td>
    </tr>
    <tr>
        <td>Description:</td>
        <td>${requestScope['product'].getDescription()}</td>
    </tr>
    <tr>
        <td>Manufacturer:</td>
        <td>${requestScope['product'].getManufacturer()}</td>
    </tr>
</table>
</body>
</html>

