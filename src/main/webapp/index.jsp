<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Quest</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://bootstrap-4.ru/docs/5.2/assets/css/docs.css" rel="stylesheet">

</head>


<body class="container py-5">

<div class="text-bg-light p-3">

<c:if test="${sessionScope.userName == null}">
    <jsp:forward page="start.jsp" />
</c:if>

    <h1 class="position-absolute top-10 start-50 translate-middle"><%= "Привет, " + request.getSession().getAttribute("userName") + "!"%></h1>
<p><p><c:out value="${sessionScope.userName}">userName</c:out>, <c:out value="${sessionScope.question}">question</c:out></p>

<form class="border" action="${pageContext.request.contextPath}/QuestServlet" method="get">

    <div>
        <input class="form-check-input" type="radio" id="answer1" name="answer" value="<%= request.getSession().getAttribute("answer1")%>">
        <label class="form-check-label" for="answer1"><%= request.getSession().getAttribute("answer1")%></label><br>
    </div>

    <div>
        <input class="form-check-input" type="radio" id="answer2" name="answer" value="<%= request.getSession().getAttribute("answer2")%>">
        <label class="form-check-label" for="answer2"><%= request.getSession().getAttribute("answer2")%></label><br>
    </div>
    <div>
        <button class="btn btn-primary">Ответить</button>
    </div>

</form>

    <div>
    <%
        Random rand = new Random();
        int n = rand.nextInt(10);
        System.out.println(n);
    %>
        <img src="${pageContext.request.contextPath}/gif/<%=n%>.gif" class="rounded mx-auto d-block" alt="picture">
    </div>

<div class="bottom" >
    <div class="text-bg-secondary p-4">
        <div class="border">
            <p>Статистика:</p>
            <p>Имя игрока: <c:out value="${sessionScope.userName}">userName</c:out></p>
            <p>IP - адрес: <c:out value="${sessionScope.IPAddress}">IPAddress</c:out></p>
            <p>Количество сыгранных игр: <c:out value="${sessionScope.gameCount}">gameCount</c:out></p>
            <p>Количество побед: <c:out value="${sessionScope.winCount}">winCount</c:out></p>
        </div>
    </div>
</div>

</div>


</body>
</html>