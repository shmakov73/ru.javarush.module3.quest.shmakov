
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Представься</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://bootstrap-4.ru/docs/5.2/assets/css/docs.css" rel="stylesheet">
</head>
<body class="container py-5">
<div class="text-bg-light p-3">
    <H1>Вступление:</H1>
    <p>
        Ты ни когда не верил в инопланетян и отрицал любые признаки их существования, считая это вымыслом и сказками и думал,
        что если даже они и есть, то человечество ещё не достаточно развито, чтобы быть готовым к такой встрече.
        Когда ты слышал по телевизору или радио об очередном случае похищения человека инопланетянами, то всегда думал,
        что человек, который об этом рассказывает либо не в себе, либо придумал это, чтобы хоть как-то засветиться
        в новостях телевидения и газет. Но всё оказалось совсем не так...
        Для начала, представься и продолжим!
    </p>
    <H2></H2>
    <p>

    </p>
    <div >
        <img src="${pageContext.request.contextPath}/gif/4519285.gif" class="rounded mx-auto d-block" alt="picture">
    </div>
<form name="addUser" method="get" action="AddUserServlet">
  <p>Представься:</p><br>
    <label>
        <input type = "text" name = "name">
    </label>
    <input type="submit" value="отправить">
    </form>
</div>
</body>
</html>
