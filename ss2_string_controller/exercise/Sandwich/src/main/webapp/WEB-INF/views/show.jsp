<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Condiment</h1>
<table border="1px">
    <tr>
        <td>#</td>
        <td>Condiment</td>
    </tr>
    <c:forEach varStatus="No" var="condiment" items="${condiment}">
        <tr>
            <td>${No.count}</td>
            <td>${condiment}</td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
