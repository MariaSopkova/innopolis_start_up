<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:base-page>
  <div class="row">
    <div class="col col-sm-3">
      <div class="user-personal sticky-top">
        <div>
          <img src="${user.avaLink}" class="img-fluid rounded">
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
        <div class="card">
          <img class="card-img-top" src="/img/dog.jpg" alt="Card image cap">
          <div class="card-body">
            <h5 class="card-title">Card title that wraps to a new line</h5>
            <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
          </div>
        </div>
        <div class="card p-3">
          <blockquote class="blockquote mb-0 card-body">
            <p>Научу вашего питомца подавать лапу! Пишите в личку</p>
            <footer class="blockquote-footer">
              <small class="text-muted">
                Иванов Иван
              </small>
            </footer>
          </blockquote>
        </div>
        <div class="card">
          <img class="card-img-top" src="/img/dog2.jpg" alt="Card image cap">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
          </div>
        </div>
        <div class="card bg-primary text-white text-center p-3">
          <blockquote class="blockquote mb-0">
            <p>Следите за новостями! Мы постоянно развиваем нашу систему! Скоро будет добавлена возможность учавствовать в выставках!</p>
            <footer class="blockquote-footer">
              <small class="text-light">
                TAKSANET - your Innopolis startup
              </small>
            </footer>
          </blockquote>
        </div>
        <div class="card text-center">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This card has a regular title and short paragraphy of text below it.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
          </div>
        </div>
        <div class="card">
          <img class="card-img" src="/img/header.jpg" alt="Card image">
        </div>
        <div class="card p-3 text-right">
          <blockquote class="blockquote mb-0">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
            <footer class="blockquote-footer">
              <small class="text-muted">
                Someone famous in <cite title="Source Title">Source Title</cite>
              </small>
            </footer>
          </blockquote>
        </div>
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">This is another card with title and supporting text below. This card has some additional content to make it slightly taller overall.</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</t:base-page>
