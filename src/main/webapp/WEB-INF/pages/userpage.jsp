<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-page>
    <div class="row">

        <div class="col-3">
            <div class="user-personal bg-light p-3 rounded">
                <div class="user-logo mb-3">
                    <img src=${user.avaLink} border="0">
                </div>
                <div class="user-personal-data">
                    <h5>${user.name} ${user.familyName}</h5>
                    <div>Возраст ${user.age}</div>
                    <div class="personal-data--item">
                        <div class="font-weight-bold">Дата</div>
                        <div>01.01.2018</div>
                        <a href="useredit/${user.id}">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">Other</div>
    </div>

</t:base-page>

