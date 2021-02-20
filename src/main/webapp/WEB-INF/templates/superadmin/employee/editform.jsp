<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card card--blue">
    <div class="card__content">
        <form:form method="POST"
                   action="${submitAction}" modelAttribute="employee" cssClass="form">
            <form:input path="userName" type="hidden"/>

            <form:label path="fullName">ФИО</form:label>
            <form:input path="fullName" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="fullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="fullName"/>
                </div>
            </form:errors>

            <form:label path="position">Позиция</form:label>
            <form:select path="position" cssClass="select select--radius">
                <form:options items="${employee.positions}"/>
            </form:select>
            <form:errors path="position">
                <div class="alert alert--radius alert--red">
                    <form:errors path="position"/>
                </div>
            </form:errors>

            <form:label path="salary">Зарплата</form:label>
            <form:input required="" path="salary" type="number" cssClass="textfield textfield--shadow"/>
            <form:errors path="salary">
                <div class="alert alert--radius alert--red">
                    <form:errors path="salary"/>
                </div>
            </form:errors>

            <form:label path="isWorking">Работает</form:label>
            <form:checkbox value="1" path="isWorking"/>

            <form:errors path="isWorking">
                <div class="alert alert--radius alert--red">
                    <form:errors path="isWorking"/>
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

            <form:label path="cashboxId">Касса</form:label>
            <form:select path="cashboxId" type="text" cssClass="textfield textfield--shadow">
                <form:options items="${employee.cashboxes}"/>
            </form:select>
            <form:errors path="cashboxId">
                <div class="alert alert--radius alert--red">
                    <form:errors path="cashboxId"/>
                </div>
            </form:errors>

            <form:label path="role">Роль</form:label>
            <form:select path="role" type="text" cssClass="textfield textfield--shadow">
                <form:options items="${employee.roles}"/>
            </form:select>
            <form:errors path="role">
                <div class="alert alert--radius alert--red">
                    <form:errors path="role"/>
                </div>
            </form:errors>

            <form:label path="affiliateId">Филиал</form:label>
            <form:select path="affiliateId" type="text" cssClass="textfield textfield--shadow">
                <form:options items="${employee.affiliates}"/>
            </form:select>
            <form:errors path="affiliateId">
                <div class="alert alert--radius alert--red">
                    <form:errors path="affiliateId"/>
                </div>
            </form:errors>

            <form:label path="comment">Комментарии</form:label>
            <form:textarea path="comment"  cssClass="textfield textfield--shadow"/>
            <form:errors path="comment">
                <div class="alert alert--radius alert--red">
                    <form:errors path="comment"/>
                </div>
            </form:errors>

            <form:input path="oldRole" type="hidden"/>

            <button class="button button--radius button--blue">
                    ${submitbtntext}
            </button>
        </form:form>
    </div>
</div>


