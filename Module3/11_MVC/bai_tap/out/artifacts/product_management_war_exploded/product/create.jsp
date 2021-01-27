<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Product</title>
</head>
<body>
<h2>Create new Product</h2>
<c:if test="${requestScope['message'] !=null}">
  <span>${requestScope['message']}</span>
</c:if>
<a href="/products">Back to product list</a>
<form method="post">
  <fieldset>
    <legend>Product</legend>
    <input type="hidden" value="create" name="action">
    <table>
      <tr>
        <td><label for="name">Name:</label></td>
        <td><input type="text" name="name" id="name"/></td>
      </tr>
      <tr>
        <td><label for="price">Price:</label></td>
        <td><input type="text" name="price" id="price"/></td>
      </tr>
      <tr>
        <td><label for="description">Description:</label></td>
        <td><input type="text" name="description" id="description"/></td>
      </tr>
      <tr>
        <td><label for="manufacturer">Manufacturer:</label></td>
        <td><input type="text" name="manufacturer" id="manufacturer"/></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create!"/></td>
      </tr>
    </table>
  </fieldset>
</form>
<form>

</form>
</body>
</html>
