<%--
  Created by IntelliJ IDEA.
  User: den
  Date: 11.12.2022
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%String message =pageContext.getException().getMessage().toString();
  String exception = pageContext.getException().getClass().toString();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Exception</title>
</head>
<body>

<h1 style="background: antiquewhite">Program got exception during processing</h1>
<div style="background: cadetblue">
<p>Type <%=message%></p>
<p>Exception <%=exception%></p>
</div>
</body>
</html>
