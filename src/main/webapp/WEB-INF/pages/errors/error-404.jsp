<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-error>
  <h1>404 Not Found</h1>
  <p class="text-muted">The requested URL <code><%= request.getAttribute("javax.servlet.error.request_uri") %></code> was not found on this server.</p>
</t:base-error>