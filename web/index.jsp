<%-- 
    Document   : index
    Created on : Dec 21, 2017, 9:18:35 AM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>List</title>
        <script
            src="http://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
        crossorigin="anonymous"></script>
        <script>

            function HienThiUserName() {
                $.ajax({
                    url: ('SearchByUsernameServlet'),
                    type: 'GET',
                    data: {
                        search: $('#search').val()
                    },
                    success: function(responseText)
                    {
                        $('searchF').val('');
                        $('#ajaxListServletResponse').html(responseText);
                    }

                });
            };
            

            function HienThiFullName() {
                $.ajax({
                    url: ('SearchByFullnameServlet'),
                    type: 'GET',
                    data: {
                        searchF: $('#searchF').val()
                    },
                    success: function(responseText)
                    {
                        $('#search').val('');
                        $('#ajaxListServletResponse').html(responseText);
                    }

                });
            };
            
            
        </script>
    </head>
    <body >

        <form action="#" method="get">
            Username: <input type="text" id="search" name="search"/>
            <input type="button" value="Search" onclick="HienThiUserName()">
        </form>

        <br>

        <form action="#" method="get">
            Fullname: <input type="text" id="searchF" name="searchF" />
            <input type="button" value="Search" onclick="HienThiFullName()">
        </form>

        <h3>Hello ${fullname} </h3> <h3><a href="LogoutServlet">Logout</a></h3>
        <div id="ajaxListServletResponse" >

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

        </div>

        <a href="CreateServlet" >Add new </a>
        <%--<button onclick="window.location.href = 'insert.jsp'">Add new</button>--%>
    </body>
</html>