
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quest</title>
</head>
<body>
<h1> Имя игрока: <c:out value="${sessionScope.userName}"></c:out></h1>
<p><c:out value="${sessionScope.userName}"></c:out>, <c:out value="${requestScope.defeatPhrase}"></c:out></p>
<form action="${pageContext.request.contextPath}/AddUserServlet" method="get">
    <p>Для того, чтобы провторить игру, нажми "start"</p>
    <input type="submit" id="restart" name="answer" value="start"/>
</form>
<div id="stat">
    <p>Статистика:</p>
    <p>Имя игрока: <c:out value="${sessionScope.userName}"></c:out></p>
    <p>IP - адрес: <c:out value="${sessionScope.IPAddress}"></c:out></p>
    <p>Количество сыгранных игр: <c:out value="${sessionScope.gameCount}"></c:out></p>
    <p>Количество побед: <c:out value="${sessionScope.winCount}"></c:out></p>
</div>
</body>
</html>
