<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/29/2022
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<center>
<h1>Dictionary</h1>
</center>
<form action="/translate" method="post">
    <table class="table table-striped table-bordered">
        <tr>
            <th>
                <input type="text" class="form-control" name="search" placeholder="Enter your word">
            </th>
            <th>
                <button type="submit" class="btn btn-primary">Search</button>
            </th>
            <th>
                <h3>Result: ${result}</h3>
            </th>
        </tr>
    </table>
<%--    <div class="form-group">--%>
<%--        <input type="text" class="form-control" name="search" placeholder="Enter your word">--%>
<%--    </div>--%>
<%--    <center>--%>
<%--    <button type="submit" class="btn btn-primary">Search</button>--%>
<%--        <br>--%>
<%--        <h3>Result: ${result}</h3>--%>
<%--    </center>--%>

</form>



<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>
