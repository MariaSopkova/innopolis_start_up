<%@tag description="User Page template" pageEncoding="UTF-8" %>
<%@attribute name="editable" required="true" type="java.lang.Boolean"%>
<%@attribute name="user" required="true" type="ru.innopolis.stc12.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="user-personal bg-light p-3 rounded">
    <div class="user-logo mb-3">
        <c:if test="${not empty user.avaLink}">
            <img src="${user.avaLink}" class="img-fluid rounded w-100">
        </c:if>
        <c:if test="${empty user.avaLink}">
            <div class="no-ava bg-dark p-5">
                <i class="fas fa-user"></i>
            </div>
        </c:if>
    </div>
    <div class="user-personal-data">
        <h5>${user.name} ${user.familyName}</h5>

        <div class="personal-data--item">
            <div class="font-weight-bold">Город</div>
            <div>${user.city}</div>
        </div>
        <div class="personal-data--item">
            <div class="font-weight-bold">Возраст</div>
            <div>${user.age}</div>
        </div>
        <c:if test="${editable}">
            <div class="py-3">
                <a class="btn btn-sm btn-primary" href="useredit/${user.id}">Редактировать</a>
            </div>
        </c:if>
    </div>
</div>