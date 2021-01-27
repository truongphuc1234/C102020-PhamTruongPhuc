<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
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
        <input type="hidden" value="delete" name="action">
        <input type="hidden" value="${requestScope['product'].getId()}" name="id">
        <table>
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
            <tr>
                <td></td>
                <td><input type="submit" value="Delete!"/></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>

