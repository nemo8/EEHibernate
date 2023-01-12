<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List</title>
    <style>
        table,th,td{border:2px solid black;padding: 10px; text-align: center;}
        table{border-collapse:collapse; position: center}
        .btn{display: inline-block;
            background: gray;
            color: aliceblue;
            padding: 5px;
            border-radius: 2px;
            text-decoration: none;
            margin: 10px;
            }
    </style>
</head>
<body>
<h2 style="text-align:center">List of pets</h2>
<a href='<c:url value="create.jsp"/>' class="btn">Create new pet</a>
<table>
    <tr><th>Type</th><th>Name</th><th>Age</th><th>Action</th></tr>
    <c:forEach var="c" items="${pets}">
        <tr><td>${c.type}</td><td>${c.name}</td><td>${c.age}</td>
            <td>
                <a href='<c:url value="/edit?id=${c.id}"/>'>Edit</a>
                <form method="post" action='<c:url value="/delete"/>' style="display:inline">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="submit" value="Del">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
