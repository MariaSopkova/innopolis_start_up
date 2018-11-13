<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:base-page>
    <div class="row">

        <div class="col-3">
            <div class="pet-personal bg-light p-3 rounded">
                <div class="user-logo mb-3">
                    <img src="https://thumb.ibb.co/dciRh0/schastlivaya-sobaka1.jpg"
                         border="0">
                </div>
                <div class="pet-personal-data">
                    <h5>${pet.name} ${pet.breed} ${pet.gender}</h5>
                    <div class="personal-data--item">
                        <div class="font-weight-bold">Дата</div>
                        <div>13.11.2018</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col">Other</div>
    </div>

</t:base-page>
