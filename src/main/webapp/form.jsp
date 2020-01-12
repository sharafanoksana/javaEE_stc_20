<%--
  Created by IntelliJ IDEA.
  User: sharafan
  Date: 12.01.2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="personUser" class="com.gmail.sharafan.entities.PersonUser" />
<c:set target="${personUser}" property="name" value="FIRST" />
<jsp:setProperty name="personUser" property="name" value="0" />


<h1>Adding a new student</h1>
<form method="post" action="${pageContext.request.contextPath}/add" autocomplete="off">
    <div class="form-group">
        <label for="name">Name</label>
        <input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="personUser" property="name" />">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input name="password" type="text" class="form-control" id="password" value="<jsp:getProperty name="personUser" property="password" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
