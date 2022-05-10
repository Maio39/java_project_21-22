<%--
  Created by IntelliJ IDEA.
  User: marcomaier
  Date: 04/10/21
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1> <%= "Register" %></h1>
    <br/>
    <form action="servlet2" method="post">
        <input type="text" name="firstName" placeholder="First-Name"/>
        <input type="text" name="lastName" placeholder="Last-Name">
        <input type="email" name="email" placeholder="E-mail"/>
        <input type="password" name="password" placeholder="Password"/>
        <input type="submit"/>
    </form>
</body>
</html>
