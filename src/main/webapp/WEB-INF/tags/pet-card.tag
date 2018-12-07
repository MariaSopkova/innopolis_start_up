<%@tag description="User Page template" pageEncoding="UTF-8" %>
<%@attribute name="userId" required="false" %>
<%@attribute name="pet" required="true" type="ru.innopolis.stc12.pojo.Pet" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card">
    <img class="card-img-top" src="/img/header2.jpg" alt="Мой питомец">
    <div class="card-body p-0">
        <h5 class="card-title pt-3 px-3">${pet.name}</h5>
        <p class="card-text description p-3">${pet.description}</p>
    </div>
    <c:if test="${not empty userId}">
        <sec:authorize access="hasAuthority(T(ru.innopolis.stc12.security.Actions).USER_PET_EDIT)">
            <div class="card-footer bg-white text-sm-center size mt-3">
                <a class="btn btn-link btn-sm text-info" href="/pet/${userId}/${pet.id}"><i
                        class="fa fa-pen"></i> Редактировать</a>
                <a class="btn btn-link btn-sm text-danger" href="#"
                   onclick="removePet(${pet.id})"><i
                        class="fa fa-times"></i> Удалить</a>
            </div>
        </sec:authorize>
    </c:if>

</div>