<%@tag description="Navigation bar" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-navbar mb-4" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/"><b>Taksa</b>net</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_DASHBOARD_VIEW)">
                    <li class="nav-item">
                        <a class="nav-link" href="/dashboard">Главная <span class="sr-only">Главная</span></a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_LIST_VIEW)">
                    <li class="nav-item">
                        <a class="nav-link" href="/userslist">Пользователи <span class="sr-only">Пользователи</span></a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item dropdown ">
                        <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <sec:authentication property="principal.username"/>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PROFILE_VIEW)">
                                <a class="dropdown-item" href="/userpage">Профиль <span class="sr-only">Профиль</span></a>
                            </sec:authorize>
                            <a class="dropdown-item text-danger" href="/static/j_spring_security_logout">Выйти</a>
                        </div>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>