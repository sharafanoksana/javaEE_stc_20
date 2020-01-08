<%--
  Created by IntelliJ IDEA.
  User: sharafan
  Date: 07.01.2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<div>
    <h1>Super app!</h1>
</div>
<div>
    <%
        if(request.getAttribute("personUserName") != null){
            out.print("<p>PersonUser '" + request.getAttribute("personUserName") + "' added!</p>");
        }
    %>
</div>
<div>
    <h2>Add user</h2>
</div>

    <form method="post">
        <label>Name:
            <input type="text" name="name"><br>
        </label>
        <label>Password
            <input type="password" name="pass"><br>
        </label>
        <button type="submit">Submit</button>
    </form>
</div>
</div>

<div>
    <button onclick="location.href='/servletExample_war'">Back to main</button>
</div>

</body>
</html>
