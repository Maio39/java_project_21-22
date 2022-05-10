<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accedi</title>
</head>
<body>
<h1><%= "Log in" %>
</h1>
<br/>
<form action="hello-servlet" method="post">
    <input type="email" name="email" placeholder="E-mail"/>
    <input type="password" name="password" placeholder="Password"/>
    <input type="submit"/>
    <br/>
    <br/>
    Se non hai un account clicca qui sotto
    <br/>
    <br/>
    <a href="register.jsp">Registrati</a>
</form>
</body>
</html>