<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new pet</title>
</head>
<body>
<form method="post" action='<c:url value="/create"/>'>
    <h2>Pet's type</h2> <input type="text" name="type"><br>
    <h2>Pet's name</h2> <input type="text" name="name"><br>
    <h2>Pet's age</h2> <input type="text" name="age"><br>
    <input type="submit" value="Create" style="margin: 10px">
</form>
</body>
</html>
