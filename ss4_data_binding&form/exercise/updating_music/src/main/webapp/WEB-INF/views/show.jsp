<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Music</title>
</head>
<body>
    <h2>Music</h2>
    <h4><a href="/update">Cập nhật bài hát</a></h4>
<table border="1px" cellpadding="0px" cellspacing="0px">
    <thead>
    <th>Tên Bài Hát</th>
    <th>Ca sĩ</th>
    <th>Thể loại</th>
    <th>Link bài hát</th>
    </thead>
    <tbody>
        <c:forEach items="${musicList}" var="musicList">
        <tr>
            <td>${musicList.songName}</td>
            <td>${musicList.singer}</td>
            <td>${musicList.type}</td>
            <td><a href="${musicList.link}">${musicList.link}</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
