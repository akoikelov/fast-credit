<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card card--blue">
    <div class="card__content">
        <form:form method="POST"
                   action="${submitAction}" modelAttribute="profile" cssClass="form">
            <%@include file="../flash.jsp" %>
            <form:input path="userName" type="hidden"/>

            <form:label path="password">Пароль</form:label>
            <form:input path="password" type="password" cssClass="textfield textfield--shadow"/>
            <form:errors path="password">
                <div class="alert alert--radius alert--red">
                    <form:errors path="password"/>
                </div>
            </form:errors>

            <form:label path="repeatPassword">Повторите пароль</form:label>
            <form:input path="repeatPassword" type="password" cssClass="textfield textfield--shadow"/>
            <form:errors path="repeatPassword">
                <div class="alert alert--radius alert--red">
                    <form:errors path="repeatPassword"/>
                </div>
            </form:errors>

            <form:label path="fullName">ФИО</form:label>
            <form:input path="fullName" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="fullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="fullName"/>
                </div>
            </form:errors>


            <br>
            <br>

            <form:label path="birthday">Дата рождения</form:label>
            <form:input path="birthday" type="date" cssClass="textfield textfield--shadow"/>
            <form:errors path="birthday">
                <div class="alert alert--radius alert--red">
                    <form:errors path="birthday"/>
                </div>
            </form:errors>

            <form:label path="passportId">Паспортные данные</form:label>
            <form:input path="passportId" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="passportId">
                <div class="alert alert--radius alert--red">
                    <form:errors path="passportId"/>
                </div>
            </form:errors>

            <form:label path="address">Адрес</form:label>
            <form:textarea path="address" cssClass="textfield textfield--shadow"/>
            <form:errors path="address">
                <div class="alert alert--radius alert--red">
                    <form:errors path="address"/>
                </div>
            </form:errors>

            <form:label path="phone">Телефон</form:label>
            <form:input path="phone" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="phone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="phone"/>
                </div>
            </form:errors>

            <form:label path="comment">Комментарии</form:label>
            <form:textarea path="comment" cssClass="textfield textfield--shadow"/>
            <form:errors path="comment">
                <div class="alert alert--radius alert--red">
                    <form:errors path="comment"/>
                </div>
            </form:errors>


            <button class="button button--radius button--blue">
                    ${submitBtnText}
            </button>
        </form:form>
    </div>
</div>

