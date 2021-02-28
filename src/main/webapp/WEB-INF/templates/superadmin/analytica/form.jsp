<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card card--blue">
    <div class="card__content">
        <form:form method="POST"
                   action="${submitAction}" modelAttribute="analytics" cssClass="form">
            <form:label path="title">Наименование</form:label>
            <form:input path="title" cssClass="textfield textfield--shadow"/>
            <form:errors path="title">
                <div class="alert alert--radius alert--red">
                    <form:errors path="title"/>
                </div>
            </form:errors>
            <form:label path="comment">Комментарий</form:label>
            <form:textarea path="comment" cssClass="textfield textfield--shadow"/>
            <form:errors path="comment">
                <div class="alert alert--radius alert--red">
                    <form:errors path="comment"/>
                </div>
            </form:errors>

            <form:label path="isIncome">Работает</form:label>
            <form:select path="isIncome">
                <form:option value="${true}" label="Приход"/>

                <form:option value="${false}" label="Расход"/>
            </form:select>
            <form:errors path="isIncome">
                <div class="alert alert--radius alert--red">
                    <form:errors path="isIncome"/>
                </div>
            </form:errors>
            <br>
            <br>
            <button class="button button--radius button--blue">
                    ${submitbtnText}
            </button>
        </form:form>
    </div>
</div>
