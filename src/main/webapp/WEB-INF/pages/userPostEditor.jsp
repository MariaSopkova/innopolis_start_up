<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:base-page>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/userpage">Профиль</a></li>
            <li class="breadcrumb-item active" aria-current="page">Сообщение</li>
        </ol>
    </nav>

    <sec:authorize
            access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_POST_EDIT)">
        <h2>${title}</h2>
        <div class="row">
            <div class="col-12 col-sm-6">
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="postTitle">Изображение:</label>
                        <div class="custom-file">
                            <input type="file" id="ava-file" name="file">
                        </div>
                        <input type="hidden" value="${post.imgLink}" name="imgLink">
                    </div>
                    <div class="form-group">
                        <label for="postTitle">Заголовок:</label>
                        <div class="text-danger">${postTitleError}</div>
                        <input class="form-control" type="text" id="postTitle" name="postTitle" value=${post.title}>
                    </div>
                    <div class="form-group">
                        <label for="postBody">Сообщение:</label>
                        <div class="text-danger">${postBodyError}</div>
                        <textarea rows="10" class="form-control" id="postBody"
                                  name="postBody">${post.body}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Тип сообщения:</label>
                        <div class="custom-control custom-radio">
                            <input type="radio" id="customRadio1" ${post.style == "simple" ? "checked" : ""} name="postType" class="custom-control-input" value="simple">
                            <label class="custom-control-label" for="customRadio1">Простое</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input type="radio" id="customRadio2" ${post.style == "accent" ? "checked" : ""} name="postType" class="custom-control-input" value="accent">
                            <label class="custom-control-label" for="customRadio2">Акцент</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </sec:authorize>
</t:base-page>
