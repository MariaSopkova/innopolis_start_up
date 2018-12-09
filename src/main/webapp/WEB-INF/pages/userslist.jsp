<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-page>
    <h3>Пользователи</h3>
    <form id="search-form" action="search" role="form">
        <input type="text" name="searchableContent" placeholder="">
        <input type="submit" value="Поиск">
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">login</th>
            <th scope="col">name</th>
            <th scope="col">gender</th>
            <th scope="col">city</th>
            <th scope="col">role</th>
            <th scope="col">enabled</th>
            <th scope="col">deleted</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <th scope="row">${user.id}</th>
                <td><a class="mr-3" href="/user/${user.id}">${user.login}</a></td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.city}</td>
                <td>${user.role}</td>
                <td>
                    <a class=${user.enabled ? " text-danger" : "text"} href="<c:url value='/availableuser/${user.id}'/>">
                            ${user.enabled ? 'Заблокировать' : 'Разблокировать'}
                    </a>
                </td>
                <td>
                    <a class=${user.deleted ? "text" : "text-danger"} href="<c:url value='/removeuser/${user.id}' />">
                            ${user.deleted ? 'Восстановить' : 'Удалить'}
                    </a>
                </td>
            </tr>

        </c:forEach>
    </table>
</t:base-page>