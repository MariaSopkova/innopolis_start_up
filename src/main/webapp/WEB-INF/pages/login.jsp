<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base>

  <div class="shadow p-3 mt-5 mb-5 bg-white rounded mx-auto" style="width: 300px;">
    <h4 class="text-center mb-4"><spring:message code="loginPage.auth"/></h4>
    <form id="login-form" action="/j_username_security_check" method="post" role="form"
          style="display: block;">
      <div class="form-group">
        <input type="text" name="j_username" id="login" tabindex="1" class="form-control"
               placeholder="<spring:message code="label.login"/>" value="">
      </div>
      <div class="form-group">
        <input type="password" name="j_password" id="password" tabindex="2" class="form-control"
               placeholder="<spring:message code="label.password"/>">
      </div>
      <div class="form-group text-center">
        <input type="submit" class="btn btn-info btn-block" value="Войти">
      </div>
      <div class="text-center">
        <small>Если нет аккаунта: <a class="mr-3" href="registration"><spring:message code="btn.registration"/></a></small>
      </div>
    </form>
  </div>
</t:base>

