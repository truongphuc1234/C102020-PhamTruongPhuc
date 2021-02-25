<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee form</title>
</head>
<body>
<h3>Welcome, Enter the employee details</h3>
<form:form method="POST" action="addEmployee" modelAttribute="employee">
<table>
    <tr>
        <td><form:label path="id">Employee's ID:</form:label></td>
        <td><form:input path="id"/></td>
    </tr>
    <tr>
        <td><form:label path="name">Employee's Name:</form:label></td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td><form:label path="contactNumber">Employee's Contact Number:</form:label></td>
        <td><form:input path="contactNumber"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="Submit"/></td>
    </tr>
</table>
</form:form>
</body>
</html>
