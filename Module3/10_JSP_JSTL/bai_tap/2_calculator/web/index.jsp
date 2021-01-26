<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="get">
    <label>First Operand: </label><br/>
    <input type="text" name="first_operand"/><br>
    <label>Operator:</label><br>
    <select name="operator">
        <option value="addition">Addition</option>
        <option value="subtracting">Subtracting</option>
        <option value="multiplication">Multiplication</option>
        <option value="division">Division</option>
    </select><br>
    <label>Second Operand: </label><br/>
    <input type="text" name="second_operand"/><br>
    <input type="submit" value="Calculator"/>
</form>
</body>
</html>
