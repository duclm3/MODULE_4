<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/20/2021
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Student</title>
</head>
<style>
    table {
        width: 100%;
    }
</style>
<body>
<table border="1">
    <tr>
        <td>STT</td>
        <td>Name</td>
        <td>Address</td>
        <td>Detail</td>
    </tr>
<c:forEach var="student" items="${students}">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.address}</td>
        <td><a href="/detail/${student.getId()}">detail</a> </td>
    </tr>

</c:forEach>
</table>
</body>
</html>
