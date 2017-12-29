<%-- 
    Document   : create
    Created on : Dec 21, 2017, 9:54:03 AM
    Author     : hoang
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Add New User1111</h1>
<form action="CreateServlet" method="post" enctype="multipart/form-data">
    Username:<input type="text" id="username" name="username"/> <br>
    Password:<input type="password" id="password" name="password"/><br>
    Full name:<input type="text" id="fullname" name="fullname"/><br>
    Photo:<input type="file" id="photo" name="photo"/><br>
    Email:<input type="email" id="email" name="email"/><br>
    Level:<input type="number" id="level" name="level"/><br>
    <input type="submit" value="Create">
</form>
</body>
</html>