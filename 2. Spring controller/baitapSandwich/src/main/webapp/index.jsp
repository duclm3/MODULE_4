<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Le Minh Duc
  Date: 21/04/2021
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/giavi">
    <input type="checkbox" id="lettuce" name="condiment" value="lettuce">
    <label for="lettuce"> Lettuce</label><br>
    <input type="checkbox" id="tomato" name="condiment" value="tomato">
    <label for="tomato"> Tomato</label><br>
    <input type="checkbox" id="mustard" name="condiment" value="mustard">
    <label for="mustard"> Mustard</label><br>
    <input type="checkbox" id="sprouts" name="condiment" value="sprouts">
    <label for="sprouts">Sprouts</label><br>
    <input type="submit" value="Submit">
  </form>
  <c:forEach var="i" items="${condiments}">
    <p>${i}</p>
  </c:forEach>
  </body>
</html>
