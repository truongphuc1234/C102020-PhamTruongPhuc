<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 1/22/2021
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="/display-discount" method="post">
    <p>Product Description</p>
    <input type="text" placeholder="Mô tả sản phẩm" name="description">
    <p>List Price</p>
    <input type="text" placeholder="Giá" name="price">
    <p>Discount Percent</p>
    <input type="text" placeholder="%" name="percent">
    <input type="submit" value="Calculate Discount">
  </form>
  </body>
</html>
