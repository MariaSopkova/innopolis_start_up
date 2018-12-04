<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-page>
    <div class="row">
        <div class="col-sm-3">
            <div class="user-personal bg-light p-3 rounded">
                <div class="user-logo mb-3">
                    <img src="C:/dev/apache-tomcat-8.5.35/bin/userPhoto/001-500x500.jpg" width="120" border="0">
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
        <div class="col-sm-9">Other</div>
    </div>
</t:base-page>

