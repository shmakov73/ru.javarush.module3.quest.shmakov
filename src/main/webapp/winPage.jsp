<%--
  Created by IntelliJ IDEA.
  User: Руслан
  Date: 12.11.2022
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><%= request.getAttribute("winPhrase")%></p>
<form action="${pageContext.request.contextPath}/AddUserServlet" method="get">
    <input type="submit" id="restart" name="answer" value="start"/>
</form>
</body>
</html>
