<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<style>
    img {
        width: 100px;
        height: auto;
    }
</style>
<body>
<h1>Danh sách khách hàng</h1>
<table class="table">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${listCustomer}">
        <tr>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.date}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><img src="<c:out value="${customer.image}"/>" alt=""/></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
