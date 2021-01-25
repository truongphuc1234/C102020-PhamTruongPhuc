<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 1/22/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<p>Product Description: <%=request.getAttribute("description")%></p>
<p>List Price: <%=request.getAttribute("price")%></p>
<p>Discount Percent: <%=request.getAttribute("percent")%></p>
<p>Discount Amount: <%=request.getAttribute("amount")%></p>
<p>Discount Price: <%=request.getAttribute("newPrice")%></p>
</body>
</html>
