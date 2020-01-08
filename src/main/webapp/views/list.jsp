<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sharafan
  Date: 07.01.2020
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div>
    <h1>Super app!</h1>
</div>
<div>
    <div>
        <div>
            <h2>User list</h2>
        </div>
        <%
            List<String> names = (List<String>) request.getAttribute("personUserNames");
            if (names != null && !names.isEmpty()){
                out.print("<ul>");
                for (String s : names){
                    out.print("<li>" + s + "</li>");
                }
                out.print("<ul>");
            }else {
                out.print("<p>There are no users yet!</p>");
            }
        %>
    </div>
</div>
<div>
    <button onclick="location.href='/servletExample_war'">Back to main</button>
</div>
</body>
</html>
