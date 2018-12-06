<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-page>
    <div class="row">
        <div class="col-sm-3">
            <div class="user-personal bg-light p-3 rounded">
                <div class="user-logo mb-3">
                    <iframe src="${user.avaLink}" class="img-fluid rounded"></iframe>
                </div>
                <div class="user-personal-data">
                    <h5>${user.name} ${user.familyName}</h5>
                    <div>Возраст ${user.age}</div>
                    <div class="personal-data--item">
                        <div class="font-weight-bold">город ${user.city}</div>
                        <a href="useredit/${user.id}">Редактировать</a>

                        <form action="updateAvatar/${user.id}" method="post" enctype="multipart/form-data">
                            <label>Обновить аватар</label>
                            Выберите файл: <input type="file" name="file"><br/>
                            <input type="submit" value="Загрузить">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9">
            <h4>Мои питомцы</h4>
            <div class="card-deck">
                <div class="card">
                    <img class="card-img-top" src="img/header2.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    </div>
                    <div class="card-footer bg-white text-sm-center size">
                        <a class="btn btn-link btn-sm text-info"><i class="fa fa-pen"></i> Редактировать</a>
                        <a class="btn btn-link btn-sm text-danger"><i class="fa fa-times"></i> Удалить</a>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="img/header.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="img/header2.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:base-page>

