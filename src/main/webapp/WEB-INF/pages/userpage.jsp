<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:base-page>
    <div class="row">
        <div class="col-sm-3">
            <div class="user-personal bg-light p-3 rounded">
                <div>
                    <iframe src="${user.avaLink}" class="img-fluid rounded"></iframe>
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
                    <div class="py-3">
                        <a class="btn btn-sm btn-primary" href="useredit/${user.id}">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9">
            <div class="text-success">${result}</div>
            <div class="text-error">${error}</div>
            <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_VIEW)">
                <h4>Мои питомцы</h4>
                <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_EDIT)">
                    <div class="btn-panel"><a href="/pet/${user.id}/0" class="btn btn-primary"><i
                            class="fa fa-plus mr-2"></i>Добавить питомца</a></div>
                </sec:authorize>
                <div class="row">
                    <c:forEach var="pet" items="${user.pets}">
                        <div class="col col-sm-4">
                            <div class="card">
                                <img class="card-img-top" src="img/header2.jpg" alt="Мой питомец">
                                <div class="card-body p-0">
                                    <h5 class="card-title pt-3 px-3">${pet.name}</h5>
                                    <p class="card-text description px-3">${pet.description}</p>
                                </div>
                                <sec:authorize
                                        access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_EDIT)">
                                    <div class="card-footer bg-white text-sm-center size">
                                        <a class="btn btn-link btn-sm text-info" href="/pet/${user.id}/${pet.id}"><i
                                                class="fa fa-pen"></i> Редактировать</a>
                                        <a class="btn btn-link btn-sm text-danger" href="#"
                                           onclick="removePet(${pet.id})"><i
                                                class="fa fa-times"></i> Удалить</a>
                                    </div>
                                </sec:authorize>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </sec:authorize>
        </div>
    </div>
    <script>
        function removePet(petId) {
            $.ajax({
                url: '/pet/remove/' + petId,
                method: 'DELETE'
            }).done(function (data) {
                console.log(data);
            });
        }
    </script>
</t:base-page>

