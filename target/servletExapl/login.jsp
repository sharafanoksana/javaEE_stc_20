<%--
  Created by IntelliJ IDEA.
  User: sharafan
  Date: 05.01.2020
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name}</title>
</head>
<body>
<div>
    <h1>Super app!</h1>
</div>
<div>
    <h2>Введите логин и пароль администратора</h2>
</div>
<div>
    <form method="post" action="MainServlet">
        <input type="text" name="login" value="oksana"/>
        <input type="password" name="password" value="sharafan"/>
        <input type="submit" value="Отправить информацию">
    </form>
</div>
</body>
</html>
