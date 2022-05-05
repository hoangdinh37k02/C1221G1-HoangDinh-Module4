<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Email</title>
</head>
<body>
    <h2>Create New Email</h2>
    <form:form action="" method="post" modelAttribute="email">
        <div>
            Language:
            <form:select name="" id="" path="language">
                <form:option value="English">English</form:option>
                <form:option value="VietNamese">VietNamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
        </div>
        <div>
            Page Sizes:
            <form:select name="" id="" path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="20">20</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select>
        </div>
        <div>
            Signature:
            <form:textarea path="signature" rows="5" cols="70" />
        </div>
        <div>
            <input type="submit" value="Register">
        </div>
    </form:form>
</body>
</html>
