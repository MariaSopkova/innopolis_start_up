<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base>

  <div class="shadow p-3 mt-5 mb-5 bg-white rounded mx-auto" style="width: 300px;">
    <h4 class="text-center mb-4">Регистрация</h4>
    <form id="login-form" action="registration" method="post" role="form"
          style="display: block;">

      <div class="form-group">
              ${firstNameError}
        <input accept-charset="UTF-8" type="text" name="firstName" id="firstName" tabindex="1" class="form-control"
               placeholder="Имя" value="">
      </div>
      <div class="form-group">
          ${surnameError}
        <input accept-charset="UTF-8" type="text" name="surname" id="surname" tabindex="2" class="form-control"
               placeholder="Фамилия" value="">
      </div>
      <div class="form-group">
          ${loginError}
        <input type="text" name="login" id="login" tabindex="3" class="form-control"
               placeholder="Логин" value="">
      </div>

      <div class="form-group">
          ${emailError}
         <input type="text" name="email" id="email" tabindex="4" class="form-control"
         placeholder="Электронная почта" value="">
      </div>

      <div class="form-group">
          ${passwordError}
        <input type="password" name="password" id="password" tabindex="5" class="form-control"
               placeholder="Пароль">
      </div>
      <div class="form-group">
          ${passwordDoubleError}
        <input type="password" name="passwordDouble" id="passwordDouble" tabindex="6" class="form-control"
               placeholder="Повторите пароль">
      </div>
      <div class="form-group text-center">
        <input type="submit" name="login-submit" id="login-submit" tabindex="7"
               class="btn btn-info btn-block" value="Зарегистрироваться">
      </div>
      <div class="text-center">
        <small>Если есть аккаунт: <a class="mr-3" href="login">Войти</a></small>
      </div>
    </form>
  </div>
</t:base>

