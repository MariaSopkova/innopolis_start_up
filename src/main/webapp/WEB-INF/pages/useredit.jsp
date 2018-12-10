<%--
  Created by IntelliJ IDEA.
  User: SHome
  Date: 20.11.2018
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:base-page>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/userpage">Профиль</a></li>
            <li class="breadcrumb-item active" aria-current="page">Редактирование</li>
        </ol>
    </nav>
    <h2>Редактирование профиля ${user.login}</h2>
    <div class="row">
        <div class="col-12 col-sm-6">
            <div>
                <img src="${user.avaLink}" class="img-fluid rounded">
            </div>
            <form action="/submit/${user.id}" method="post" enctype="multipart/form-data">
                <div class="custom-file">
                    <input type="file" id="ava-file" name="file">
                </div>
                <input type="hidden" value="${user.avaLink}" name="avaLink">
                <div class="form-group">
                    <label for="firstName">Имя:</label>
                    <input class="form-control" type="text" id="firstName" name="firstName" value="${user.name}">
                </div>
                <div class="form-group">
                    <label for="lastName">Фамилия:</label>
                    <input class="form-control" type="text" id="lastName" name="lastName" value="${user.familyName}">
                </div>
                <div class="form-group">
                    <label for="city">Город:</label>
                    <input class="form-control" type="text" id="city" name="city" value="${user.city}">
                </div>
                <div class="form-group">
                    <label for="city">Возраст:</label>
                    <input class="form-control" type="number" min="3" id="age" name="age" value="${user.age}">
                </div>
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </form>
        </div>
        <div class="col"></div>
    </div>

</t:base-page>
