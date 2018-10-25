<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base>

  <div class="shadow p-3 mt-5 mb-5 bg-white rounded mx-auto" style="width: 300px;">
    <h4 class="text-center mb-4">Авторизация</h4>
    <form id="login-form" action="login" method="post" role="form"
          style="display: block;">
      <div class="form-group">
        <input type="text" name="login" id="login" tabindex="1" class="form-control"
               placeholder="Логин" value="">
      </div>
      <div class="form-group">
        <input type="password" name="password" id="password" tabindex="2" class="form-control"
               placeholder="Пароль">
      </div>
      <div class="form-group text-center">
        <input type="submit" name="login-submit" id="login-submit" tabindex="4"
               class="btn btn-info btn-block" value="Войти">
      </div>
      <div class="text-center">
        <small>Если нет аккаунта: <a class="mr-3" href="registration">Регистрация</a></small>
      </div>
    </form>
  </div>
</t:base>

