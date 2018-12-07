<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:base-page>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/dashboard">Главная</a></li>
            <li class="breadcrumb-item active" aria-current="page">${user.name} ${user.familyName}</li>
        </ol>
    </nav>
    <div class="row">
        <div class="col-sm-3">
            <t:user-card editable="false" user="${user}"/>
        </div>
        <div class="col-sm-9">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pets-tab" data-toggle="tab" href="#pets"
                       role="tab" aria-controls="pets" aria-selected="true">Питомцы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="posts-tab" data-toggle="tab"
                       href="#posts" role="tab" aria-controls="posts" aria-selected="false">Посты</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active pt-3" id="pets" role="tabpanel" aria-labelledby="pets-tab">
                    <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_VIEW)">
                        <div class="card-columns">
                            <c:forEach var="pet" items="${user.pets}">
                                <t:pet-card pet="${pet}"/>
                            </c:forEach>
                        </div>
                    </sec:authorize>
                </div>
                <div class="tab-pane fade pt-3" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                    <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_POST_VIEW)">
                        <div class="card-columns">
                            <c:forEach var="post" items="${user.posts}">
                                <t:user-post-card post="${post}"/>
                            </c:forEach>
                        </div>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</t:base-page>

