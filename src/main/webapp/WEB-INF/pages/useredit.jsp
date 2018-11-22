<%--
  Created by IntelliJ IDEA.
  User: SHome
  Date: 20.11.2018
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование профиля</title>
</head>
<body>

<%--
/*
* В адресе запросе передаётся также ID пользователя
* По кнопке "Венрнуться" возвращаемся на страницу пользователя
*/

--%>

<h2>Редактирование профиля ${user.login}</h2>

<form action="/submit/${user.id}" method="post">
    <a href="/userpage">Вернуться</a>
    <br><br>
    Имя:<br>
    <input type="text" name="firstName" value=${user.name}>
    <br>
    Фамилия:<br>
    <input type="text" name="lastName" value=${user.familyName}>
    <br>
    Город:<br>
    <input type="text" name="city" value=${user.city}>
    <br>
    Возраст:<br>
    <input type="text" name="age" value=${user.age}>
    <br>
    <br><br>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
