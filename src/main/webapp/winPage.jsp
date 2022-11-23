
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>Ты победил!</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://bootstrap-4.ru/docs/5.2/assets/css/docs.css" rel="stylesheet">

</head>
<body class="container py-5">
<div class="text-bg-light p-3">
<h1 class="position-absolute top-10 start-50 translate-middle">Поздравляю, </h1>
<p><p><c:out value="${sessionScope.userName}"></c:out>, <c:out value="${requestScope.winPhrase}"></c:out></p></p>
<form action="${pageContext.request.contextPath}/AddUserServlet" method="get">
    <p>Для того, чтобы провторить игру, нажми "start"</p>
    <input class="btn btn-primary" type="submit" id="restart" name="answer" value="start"/>
</form>

<div>
    <%
        Random rand = new Random();
        int n = rand.nextInt(10);
        System.out.println(n);
    %>
    <img src="${pageContext.request.contextPath}/gif/<%=n%>.gif" class="rounded mx-auto d-block">
</div>


<div class="bottom" >
    <div class="text-bg-secondary p-4">
        <div class="border">
            <p>Статистика:</p>
            <p>Имя игрока: <c:out value="${sessionScope.userName}"></c:out></p>
            <p>IP - адрес: <c:out value="${sessionScope.IPAddress}"></c:out></p>
            <p>Количество сыгранных игр: <c:out value="${sessionScope.gameCount}"></c:out></p>
            <p>Количество побед: <c:out value="${sessionScope.winCount}"></c:out></p>
        </div>
    </div>
</div>
</div>
</body>
</html>
