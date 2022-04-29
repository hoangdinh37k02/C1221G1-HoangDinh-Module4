<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/29/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/transfer" method="post">
    <div>
        Rate:
        <input type="text" name="rate" value="22000" disabled>
    </div>
    <div>
        Nhập USD:
        <input type="number" name="usd">
    </div>
    <div><input type="submit" value="Convert"></div>
    <div>Result: ${result}</div>
</form>
</body>
</html>
