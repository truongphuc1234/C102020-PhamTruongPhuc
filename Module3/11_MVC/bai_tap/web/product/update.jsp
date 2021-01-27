<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h2>Update Product</h2>
<c:if test="${requestScope['message'] !=null}">
    <span>${requestScope['message']}</span>
</c:if>
<a href="/products">Back to product list</a>
<form method="post">
    <fieldset>
        <legend>Product</legend>
        <input type="hidden" value="update" name="action">
        <input type="hidden" value="${requestScope['product'].getId()}" name="id">
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" name="name" id="name" value="${requestScope['product'].getName()}"/></td>
            </tr>
            <tr>
                <td><label for="price">Price:</label></td>
                <td><input type="text" name="price" id="price" value="${requestScope['product'].getPrice()}"/></td>
            </tr>
            <tr>
                <td><label for="description">Description:</label></td>
                <td><input type="text" name="description" id="description"
                           value="${requestScope['product'].getDescription()}"/></td>
            </tr>
            <tr>
                <td><label for="manufacturer">Manufacturer:</label></td>
                <td><input type="text" name="manufacturer" id="manufacturer"
                           value="${requestScope['product'].getManufacturer()}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update!"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

