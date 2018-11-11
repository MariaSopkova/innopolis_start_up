<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-page>
    <h3>Users list</h3>
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
                <th scope="col"></th>
            </tr>
            </thead>
            <c:forEach var="user" items="${users}">
                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.login}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.city}</td>
                    <td>${user.role}</td>
                    <td><a href="<c:url value='/avaibleuser/${user.id}' />" >${user.enabled}</a></td>
                    <td><a href="<c:url value='/removeuser/${user.id}' />" >Delete</a></td>
                </tr>

            </c:forEach>
        </table>
</t:base-page>