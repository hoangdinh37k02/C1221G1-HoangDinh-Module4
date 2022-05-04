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
<h1>Gia vị đã chọn</h1>
<table border="1px">
    <tr>
        <td>STT</td>
        <td>Gia vị</td>
    </tr>
    <c:forEach varStatus="No" var="muoi" items="${muoi}">
        <tr>
            <td>${No.count}</td>
            <td>${muoi}</td>
        </tr>

    </c:forEach>

</table>
<%--    <c:forEach--%>
<%--    <h2>${mam}</h2>--%>
<%--    <h2>${muoi}</h2>--%>
</body>
</html>
