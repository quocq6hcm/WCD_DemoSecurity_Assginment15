<%-- 
    Document   : ListUser
    Created on : Dec 26, 2017, 11:45:51 AM
    Author     : hoang
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Users"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <table border="1" cellspacing="0" cellpadding="5">

            <caption><h1>List of Users</h1></caption>
            <thead>
                <tr>
                    <td>username</td>
                    <td>Fullname</td>
                    <td>Photo</td>
                    <td>Email</td>
                    <td>level</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="e">
                    <tr>
                        <td>${e.username}</td>
                        <td>${e.fullname}</td>
                        <td><img src="resources/images/${e.photo}" alt="${e.photo}" height="80px"></td>
                        <td>${e.email}</td>
                        <td>${e.level}</td>
                        <td>
                            <a href="admin/RemoveServlet?username=${e.username}"  onclick="return confirm('are you sure delete user?');">Delete</a> |
                            <a href="UpdateServlet?username=${e.username}">Update</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>

        </table>
    </body>
</html>
