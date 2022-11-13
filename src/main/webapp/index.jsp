<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="style.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>

</head>
<body>
<h1><%= "Hello, " + request.getSession().getAttribute("userName") + "!"%></h1>
<p><p><%= request.getAttribute("question")%></p>

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

<p>Имя игрока: <%= request.getSession().getAttribute("userName")%></p>
<p>IP - адрес: <%= request.getSession().getAttribute("IPAddress")%></p>
<p>Количество сыгранных игр: <%= request.getSession().getAttribute("gameCount")%></p>

</body>
</html>