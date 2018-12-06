<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:base-error>
  <h1>404</h1>
  <h2>Страница не найдена</h2>
  <p class="text-muted">Запрашиваемый URL не найден.</p>
  ${pageContext.errorData.throwable.printStackTrace()}
</t:base-error>