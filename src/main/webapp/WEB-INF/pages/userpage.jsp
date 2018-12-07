<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c1" uri="http://cloudinary.com/jsp/taglib" %>
<t:base-page>

    <c:set var="active" value="${(empty param.active) ? 'pets' : param.active}" />

    <div class="row">
        <div class="col-sm-3">
            <t:user-card editable="true" user="${user}"/>
        </div>
        <div class="col-sm-9">
            <div class="text-success">${result}</div>
            <div class="text-error">${error}</div>

            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link ${active == "pets" ? "active" : ""}" id="pets-tab" data-toggle="tab" href="#pets" role="tab" aria-controls="pets" aria-selected="true">Мои Питомцы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${active == "posts" ? "active" : ""}" id="posts-tab" data-toggle="tab" href="#posts" role="tab" aria-controls="posts" aria-selected="false">Мои посты</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade ${active == "pets" ? "show active" : ""}" id="pets" role="tabpanel" aria-labelledby="pets-tab">
                    <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_VIEW)">
                        <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_EDIT)">
                            <div class="btn-panel"><a href="/pet/${user.id}/0" class="btn btn-primary"><i
                                    class="fa fa-plus mr-2"></i>Добавить питомца</a></div>
                        </sec:authorize>
                        <div class="row">
                            <c:forEach var="pet" items="${user.pets}">
                                <div class="col col-sm-4">
                                    <t:pet-card userId="${user.id}" pet="${pet}"/>
                                </div>
                            </c:forEach>
                        </div>
                    </sec:authorize>
                </div>
                <div class="tab-pane fade ${active == "posts" ? "show active" : ""}" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                    <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_POST_VIEW)">
                        <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_POST_EDIT)">
                            <div class="btn-panel"><a href="/post/${user.id}/0" class="btn btn-primary"><i
                                    class="fa fa-plus mr-2"></i>Добавить сообщение</a></div>
                        </sec:authorize>
                        <div class="row">
                            <c:forEach var="post" items="${user.posts}">
                                <div class="col col-sm-4">
                                    <t:user-post-card post="${post}" userId="${user.id}"/>
                                </div>
                            </c:forEach>
                        </div>
                    </sec:authorize>
                </div>
            </div>


        </div>
    </div>
</t:base-page>

