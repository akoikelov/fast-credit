<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<l:base>
    <jsp:attribute name="title">Add new client</jsp:attribute>
    <jsp:attribute name="content">
        <div class="form">
            <h1>Add new affilates</h1>
            <form:form method="post" action="/affiliates/created" modelAttribute="affiliates" >
            <div class="form__group">
                <div class="form__label">
                    <form:label path="title">Введите имя </form:label>
                </div>
                <form:input path="title" cssClass="textfield"  />
            </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="maxSumMonth">Введите максимальную сумму в месяц </form:label>
                    </div>
                    <form:input path="maxSumMonth" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="maxSumDay">Введите максимальную сумму в день </form:label>
                    </div>
                    <form:input path="maxSumDay" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="maxDays">Введите максимальную кол-во дней </form:label>
                    </div>
                    <form:input path="maxDays" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="maxMonths">Введите максимальную кол-во месяцев </form:label>
                    </div>
                    <form:input path="maxMonths" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="minPercentage">Введите минимальный процент </form:label>
                    </div>
                    <form:input path="minPercentage" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="comment">Введите комментарий </form:label>
                    </div>
                    <form:input path="comment" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="phone">Введите номер телефона </form:label>
                    </div>
                    <form:input path="phone" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="address">Введите адрес </form:label>
                    </div>
                    <form:input path="address" cssClass="textfield"/>
                </div>
                <div class="form__group">
                    <div class="form__label">
                        <form:label path="prefix">Введите префикс </form:label>
                    </div>
                    <form:input path="prefix" cssClass="textfield"/>
                </div>
               <input type="submit" value="Сохранить" class="button button--green"/>

            </form:form>

        </div>


    </jsp:attribute>

</l:base>