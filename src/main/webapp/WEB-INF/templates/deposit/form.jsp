<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="card card--blue">
    <div class="card__content">
        <c:set var="now" value="<% = new java.util.Date()%>"/>
        <form:form method="POST"
                   action="${submitAction}" modelAttribute="deposit" cssClass="form">
            <form:label path="title">Наименование</form:label>
            <form:input path="title" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="title">
                <div class="alert alert--radius alert--red">
                    <form:errors path="title"/>
                </div>
            </form:errors>

            <form:label path="price">Прайс</form:label>
            <form:input path="price" type="number" cssClass="textfield textfield--shadow"/>
            <form:errors path="price">
                <div class="alert alert--radius alert--red">
                    <form:errors path="price"/>
                </div>
            </form:errors>

            <form:label path="notes">Заметки</form:label>
            <form:input path="notes" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="notes">
                <div class="alert alert--radius alert--red">
                    <form:errors path="notes"/>
                </div>
            </form:errors>

            <form:label path="comment">Комментарий</form:label>
            <form:textarea path="comment" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="comment">
                <div class="alert alert--radius alert--red">
                    <form:errors path="comment"/>
                </div>
            </form:errors>

            <form:input path="customerId" type="hidden"/>


            <button class="button button--radius button--blue">
                    ${submitbtn}
            </button>
        </form:form>
    </div>
</div>
