<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-error>
    <h1>410 Gone</h1>
    <p class="text-muted"><%= request.getAttribute("javax.servlet.error.message") %></p>
</t:base-error>
