<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card card--blue">
<div class="card__content">
<form:form method="POST"
           action="${submitAction}" modelAttribute="cashbox" cssClass="form">
    <form:label path="title">Название кассы</form:label>
    <form:input path="title"  type="text" cssClass="textfield textfield--shadow"/>
    <form:errors path="title">
        <div class="alert alert--radius alert--red">
            <form:errors path="title"/>
        </div>
    </form:errors>
    <form:label path="affiliateId">Филиал</form:label>
        <form:select path="affiliateId" type="text" cssClass="textfield textfield--shadow">
       <form:options items="${cashbox.affiliates}"/>
    </form:select>
    <form:errors path="affiliateId">
        <div class="alert alert--radius alert--red">
            <form:errors path="affiliateId"/>
        </div>
    </form:errors>

    <form:label path="comment">Комментарий</form:label>
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