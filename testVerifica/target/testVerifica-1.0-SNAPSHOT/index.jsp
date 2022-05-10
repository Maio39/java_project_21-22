<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1><%= "Register" %>
</h1>
<br/>
<form action="hello-servlet" method="post">
    <input type="email" name="email" placeholder="E-Mail"/>
    <input type="text" name="first-name" placeholder="first-name"/>
    <input type="text" name="last-name" placeholder="last-name"/>
    <input type="password" name="password" placeholder="Password"/>
    <input type="submit"/>
</form>
<form action="hello-servlet" method="get">
    <h4> salvataggio </h4>
</form>
</body>
</html>