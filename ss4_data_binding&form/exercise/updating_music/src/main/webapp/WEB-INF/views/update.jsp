<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="" modelAttribute="music" method="post">
    <table border="1px">
        <tr>
            <th>Tên bài hát: </th>
            <td>
                <form:input type="text" path="songName"/>
            </td>
        </tr>
        <tr>
            <th>Ca sĩ: </th>
            <td>
                <form:input type="text" path="singer"/>
            </td>
        </tr>
        <tr>
            <th>Thể loại: </th>
            <td>
                <form:select path="type">
                    <form:option value="Quẩy">Quẩy</form:option>
                    <form:option value="IDM">IDM</form:option>
                    <form:option value="Rock">Rock</form:option>
                    <form:option value="Bolero">Bolero</form:option>
                </form:select>
<%--                <form:input type="text" path="type"/>--%>
            </td>
        </tr>
        <tr>
            <th>Đường link: </th>
            <td>
                <form:input type="text" path="link"/>
            </td>
        </tr>

    </table>
    <table border="1px"><tr> <th><input type="submit" value="Cập nhật"></th></tr></table>
</form:form>
</body>
</html>
