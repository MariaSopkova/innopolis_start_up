<%@ tag description="Simple Wrapper Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Dog Social Network</title>

  <spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
  <spring:url value="/resources/css/base.css" var="baseCss"/>
  <spring:url value="/resources/vendor/jquery/jquery-3.3.1.min.js" var="jqueryJs"/>
  <spring:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapJs"/>

  <!-- Bootstrap core CSS -->
  <link href="${bootstrapCss}" rel="stylesheet"/>

  <!-- Custom styles  -->
  <link href="${baseCss}" rel="stylesheet"/>
</head>
<body>
<div class="container">
  <div class="well">
    <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_DASHBOARD_VIEW)">
      <a href="#">Dashboard</a>
    </sec:authorize>

    <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PROFILE_VIEW)">
      <a href="#">Profile</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
      <sec:authentication property="principal.username" />
      <sec:authentication property="principal.role" />
    </sec:authorize>
  </div>

  <jsp:doBody/>
</div>
<!-- Bootstrap core JavaScript -->
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>