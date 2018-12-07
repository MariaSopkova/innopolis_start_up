<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:base-page>
  <div class="row">
    <div class="col col-sm-3">
      <div class="user-personal sticky-top">
        <div class="user-logo my-3">
          <img src="${user.avaLink}" class="img-fluid rounded w-100" >
        </div>
        <div class="user-personal-data">
          <h5>${user.name} ${user.familyName}</h5>
          <div class="personal-data--item">
            <div class="font-weight-bold">Город</div>
            <div>${user.city}</div>
          </div>
          <div class="personal-data--item">
            <div class="font-weight-bold">Возраст</div>
            <div>${user.age}</div>
          </div>
        </div>
      </div>
    </div>
    <div class="col col-sm-9">
      <h4>Записи сообщества</h4>
      <div class="card-columns">
        <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_POST_VIEW)">
          <c:forEach var="post" items="${posts}">
            <t:user-post-card post="${post}" showAuthor="true"/>
          </c:forEach>
        </sec:authorize>
      </div>
    </div>
  </div>
</t:base-page>
