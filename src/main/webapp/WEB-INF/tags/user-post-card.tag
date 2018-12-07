<%@tag description="User Page template" pageEncoding="UTF-8" %>
<%@attribute name="userId" required="false" %>
<%@attribute name="showAuthor" required="false" type="java.lang.Boolean" %>
<%@attribute name="post" required="true" type="ru.innopolis.stc12.pojo.UserPost" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card ${post.style}">
    <div class="card-body p-0">
        <h5 class="card-title pt-3 px-3">${post.title}</h5>
        <p class="card-text description px-3">${post.body}</p>
        <c:if test="${showAuthor}">
            <p class="card-text author p-3"><a href="/userpage/${post.user.id}">${post.user.name} ${post.user.familyName}</a></p>
        </c:if>
    </div>
    <c:if test="${not empty userId}">
        <sec:authorize
                access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_POST_EDIT)">
            <div class="card-footer bg-white text-sm-center size mt-3">
                <a class="btn btn-link btn-sm text-info" href="/post/${userId}/${post.id}">
                    <i class="fa fa-pen"></i> Редактировать</a>
                <a class="btn btn-link btn-sm text-danger" href="#"
                   onclick="removePost(${post.id})"><i class="fa fa-times"></i> Удалить</a>
            </div>
        </sec:authorize>
    </c:if>
</div>