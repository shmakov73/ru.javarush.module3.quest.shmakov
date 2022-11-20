<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="style.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quest</title>

</head>
<body>
<h1><%= "Hello, " + request.getSession().getAttribute("userName") + "!"%></h1>
<p><p><c:out value="${sessionScope.userName}"></c:out>, <c:out value="${requestScope.question}"></c:out></p></p>

<form action="${pageContext.request.contextPath}/QuestServlet" method="get">

    <div>
    <input type="radio" id="answer1" name="answer" value="<%= request.getAttribute("answer1")%>">
    <label for="answer1"><%= request.getAttribute("answer1")%></label><br>
    </div>

    <div>
    <input type="radio" id="answer2" name="answer" value="<%= request.getAttribute("answer2")%>">
    <label for="answer2"><%= request.getAttribute("answer2")%></label><br>
    </div>
    <div>
        <button>Ответить</button>
    </div>
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