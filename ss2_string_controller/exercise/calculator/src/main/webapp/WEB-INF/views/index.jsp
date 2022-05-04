<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2022
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="calculator" method="post">
    <input type="number" name="num1" value="0">
    <input type="number" name="num2" value="0"> <br>
    <button type="submit" value="+" name="result">Addition (+)</button>
    <button type="submit" value="-" name="result">Subtraction (-)</button>
    <button type="submit" value="*" name="result">Multiplication*</button>
    <button type="submit" value="/" name="result">Division (/)</button>
  </form>

  <h2>Result: ${final_result}</h2>
  </body>
</html>
