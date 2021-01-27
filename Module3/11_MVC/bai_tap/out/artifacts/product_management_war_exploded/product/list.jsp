<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<a href="<c:url value="/products?action=create"/>">Create new Product</a><br>
<form method="get" action="/products">
    <input type="hidden" value="findByName" name="action"/>
    <label for="name">Find by name : </label><input type="text" name="name" id = "name">
    <input type="submit" value="Search"/>
</form>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope['products']}" var="product">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.manufacturer}"/></td>
            <td><a href="<c:url value="/products?action=update&id=${product.id}"/>">Update</a></td>
            <td><a href="<c:url value="/products?action=delete&id=${product.id}"/>">Delete</a></td>
            <td><a href="<c:url value="/products?action=detail&id=${product.id}"/>">View</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
