<%@tag description="Navigation bar" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_DASHBOARD_VIEW)">
                <li class="nav-item">
                    <a class="nav-link" href="/">Dashboard <span class="sr-only">Dashboard</span></a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PROFILE_VIEW)">
                <li class="nav-item">
                    <a class="nav-link" href="/userpage">Profile <span class="sr-only">Profile</span></a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_DASHBOARD_VIEW)">
                <li class="nav-item">
                    <a class="nav-link" href="/userslist">Users list <span class="sr-only">Users list</span></a>
                </li>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <li class="nav-item dropdown ">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <sec:authentication property="principal.username"/>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item text-danger" href="/static/j_spring_security_logout">Выйти</a>
                    </div>
                </li>
            </sec:authorize>
        </ul>
    </div>
</nav>