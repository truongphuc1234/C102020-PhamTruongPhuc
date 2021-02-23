<%--
  Created by IntelliJ IDEA.
  User: phuc
  Date: 23/02/2021
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Store</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="save" method="get">
    <input type="checkbox" name="condiment" value="Lettuce" id="lettuce"/>
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" value="Tomato" id="tomato"/>
    <label for="tomato">Tomato</label>
    <input type="checkbox" name="condiment" value="Mustard" id="mustard"/>
    <label for="mustard">Mustard</label>
    <input type="checkbox" name="condiment" value="Sprouts" id="sprouts"/>
    <label for="sprouts">Sprouts</label>

    <input type="submit" value="Save">
  </form>
  </body>
</html>
