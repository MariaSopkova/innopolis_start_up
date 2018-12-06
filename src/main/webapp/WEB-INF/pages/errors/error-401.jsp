<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-error>
    <h1>401 Authorization Error</h1>
    ${pageContext.errorData.throwable.printStackTrace()}
</t:base-error>