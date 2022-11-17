<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="ru.javarush.controller.AddUserServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><%= request.getAttribute("winPhrase")%></p>
<% Logger logger = LoggerFactory.getLogger(AddUserServlet.class); %>
<form action="${pageContext.request.contextPath}/AddUserServlet" method="get">
    <% logger.info("User {} is win", request.getSession().getAttribute("userName"));%>
    <input type="submit" id="restart" name="answer" value="start"/>
</form>
</body>
</html>
