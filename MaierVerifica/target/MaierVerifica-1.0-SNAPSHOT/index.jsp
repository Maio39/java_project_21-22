<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione</title>
</head>
<h1>Registrazione</h1>
<body>
<form action="hello-servlet" method="post">
    <input type="email" name="email" placeholder="E-Mail"/>
    <input type="text" name="first-name" placeholder="first-name"/>
    <input type="text" name="last-name" placeholder="last-name"/>
    <input type="password" name="password" placeholder="Password"/>
    <input type="submit"/>
</form>
<br/>
Se hai gia effettuato la registrazione accedi qui sotto
<br>
<a href="login.jsp">Login</a>
</body>
</html>