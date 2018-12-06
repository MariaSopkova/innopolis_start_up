<%@ tag description="Base Page for logged user" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dog Social Network</title>

    <spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/creative.css" var="baseCss"/>
    <spring:url value="/resources/vendor/fontawesome-free/css/all.min.css" var="fontAwesome"/>
    <spring:url value="/resources/vendor/jquery/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/js/creative.js" var="creativeJs"/>

    <!-- Bootstrap core CSS -->
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <!-- Custom fonts -->
    <link href="${fontAwesome}" rel="stylesheet" type="text/css">

    <!-- Custom styles  -->
    <link href="${baseCss}" rel="stylesheet"/>
    <link href="/resources/css/base.css" rel="stylesheet"/>

</head>
<body>
    <t:nav-bar></t:nav-bar>
    <div class="container">
        <jsp:doBody/>
    </div>
<!-- Bootstrap core JavaScript -->
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<!-- Plugin JavaScript -->
<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/resources/vendor/scrollreveal/scrollreveal.min.js"></script>
<script src="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
<!-- Custom scripts for this template -->
<script src="${creativeJs}"></script>

</body>
</html>