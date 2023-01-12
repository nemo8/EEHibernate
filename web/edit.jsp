<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form method="post" action='<c:url value="/edit"/>'>
    <h3>Pet's type</h3><input type="text" name="type" value="${type}"><br>
    <h3>Pet's name</h3> <input type="text" name="name" value="${name}"><br>
    <h3>Pet's age</h3> <input type="text" name="age" value="${age}"><br>
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="Accept" style="margin: 10px">
</form>

</body>
</html>
