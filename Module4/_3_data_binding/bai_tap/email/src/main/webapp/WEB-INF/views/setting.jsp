<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Update</h1>
<form:form modelAttribute="setting" action="/update" method="post">
    <table>
        <tr>
            <td><form:label path="language">Languages</form:label></td>
            <td><form:select path="language" items="${countries}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Sizes</form:label></td>
            <td><form:select path="pageSize" items="${pageSizes}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spam Filter</form:label></td>
            <td><form:checkbox path="spamFilter"/></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
    </table>

    <input type="submit" value="Update">
</form:form>
</body>
</html>
