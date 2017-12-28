<%-- 
    Document   : login
    Created on : Dec 28, 2017, 2:34:58 PM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
<form method="POST" action="j_security_check">
    <table>
        <tr>
            <td colspan="2">Login to the Tomcat-Demo application:</td>
        </tr>
        <tr>
            <td>UserName:</td>
            <td><input type="text" name="j_username" value="admin"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="j_password"value="admin" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Go"/></td>
        </tr>
    </table>
</form>
    </body>
</html>
