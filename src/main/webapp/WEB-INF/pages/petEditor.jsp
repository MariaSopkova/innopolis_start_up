<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:base-page>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/userpage">Профиль</a></li>
            <li class="breadcrumb-item active" aria-current="page">Питомец</li>
        </ol>
    </nav>

    <sec:authorize
            access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_EDIT)">
        <h2>${title}</h2>
        <div class="row">
            <div class="col-12 col-sm-6">
                <form method="post">
                    <div class="form-group">
                        <label for="name">Имя:</label>
                        <div class="text-danger">${nameError}</div>
                        <input class="form-control" type="text" id="name" name="name" value=${pet.name}>
                    </div>
                    <div class="form-group">
                        <label for="breed">Порода:</label>
                        <div class="text-danger">${breedError}</div>
                        <input class="form-control" type="text" id="breed" name="breed" value=${pet.breed}>
                    </div>
                    <div class="form-group">
                        <label for="description">Описание:</label>
                        <div class="text-danger">${descriptionError}</div>
                        <textarea rows="10" class="form-control" id="description"
                                  name="description">${pet.description}</textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
            <div class="col"></div>
        </div>
    </sec:authorize>
</t:base-page>
