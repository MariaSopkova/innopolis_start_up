<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:base-error>
    <h1>500 Что-то пошло не так</h1>
    <p class="text-muted">Но мы уже работаем над этим!</p>
    ${pageContext.errorData.throwable.printStackTrace()}
    <c:if test="${showError}">
        <pre class="text-danger">${pageContext.errorData.throwable.cause}</pre>
        Больше информации в логе приложения
    </c:if>
</t:base-error>