
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculate" method="post">
    <input type="number" name="number_1"/>
    <input type="number" name="number_2"/>
    <br/>
    <input type="submit" name="operation" value="Addition">
    <input type="submit" name="operation" value="Subtraction">
    <input type="submit" name="operation" value="Multiplication">
    <input type="submit" name="operation" value="Division">
  </form>
  <h3>Result ${operation}:</h3>
  <h5>${result}</h5>
  </body>
</html>
