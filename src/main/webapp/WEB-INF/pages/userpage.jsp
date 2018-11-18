<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<t:base-page>
    <div class="row">

        <div class="col-sm-3">
            <div class="user-personal bg-light p-3 rounded">
                <div class="user-logo mb-3">
                    <img src="https://thumb.ibb.co/h6rxYV/dog-and-man-175549-1920.jpg" alt="dog-and-man-175549-1920"
                         border="0" class="rounded mx-auto d-block">
                </div>
                <div class="user-personal-data">
                    <h5>${user.name} ${user.familyName}</h5>
                    <div class="personal-data--item">
                        <div class="font-weight-bold">Дата</div>
                        <div>01.01.2018</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9">Other</div>
    </div>

</t:base-page>

