<%-- 
    Document   : update
    Created on : Dec 21, 2017, 10:56:34 AM
    Author     : hoang
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h1>Update User</h1>
<form action="UpdateServlet" method="post">
    Username:<input type="text" id="username" name="username" value="${user.username}" readonly/> <br>
    Password:<input type="password" id="password" name="password" value="${user.password}"/><br>
    Full name:<input type="text" id="fullname" name="fullname" value="${user.fullname}"/><br>
    Photo:<input type="file" id="photo" name="photo" value="${user.photo}"/><br>
    Email:<input type="email" id="email" name="email" value="${user.email}"/><br>
    Level:<input type="number" id="level" name="level" value="${user.level}"/><br>
    <input type="submit" value="Update">
</form>
</body>
</html>