<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card card--blue">
    <div class="card__content">
        <form:form method="POST"
                   action="${submitAction}" modelAttribute="form" cssClass="form">

            <form:label path="title">Название</form:label>
            <form:input path="title" cssClass="textfield textfield--shadow"/>

            <form:errors path="title">
                <div class="alert alert--radius alert--red">
                    <form:errors path="title" />
                </div>
            </form:errors>

            <form:label path="maxSumMonth">Макс сумма (при ежемесячной оплате)</form:label>
            <form:input path="maxSumMonth" type="number" cssClass="textfield textfield--shadow"/>

            <form:errors path="maxSumMonth">
                <div class="alert alert--radius alert--red">
                    <form:errors path="maxSumMonth" />
                </div>
            </form:errors>

            <form:label path="maxSumDay">Макс сумма (при ежедневной оплате)</form:label>
            <form:input path="maxSumDay" type="number" cssClass="textfield textfield--shadow"/>

            <form:errors path="maxSumDay">
                <div class="alert alert--radius alert--red">
                    <form:errors path="maxSumDay" />
                </div>
            </form:errors>

            <form:label path="maxDays">Макс кол-во дней</form:label>
            <form:input path="maxDays" type="number" cssClass="textfield textfield--shadow"/>

            <form:errors path="maxDays">
                <div class="alert alert--radius alert--red">
                    <form:errors path="maxDays" />
                </div>
            </form:errors>

            <form:label path="maxMonths">Макс кол-во месяцев</form:label>
            <form:input path="maxMonths" type="number" cssClass="textfield textfield--shadow"/>

            <form:errors path="maxMonths">
                <div class="alert alert--radius alert--red">
                    <form:errors path="maxMonths" />
                </div>
            </form:errors>

            <form:label path="minPercentage">Мин процентная ставка</form:label>
            <form:input path="minPercentage" type="number" step="0.01" cssClass="textfield textfield--shadow"/>

            <form:errors path="minPercentage">
                <div class="alert alert--radius alert--red">
                    <form:errors path="minPercentage" />
                </div>
            </form:errors>

            <form:label path="comment">Комментарий</form:label>
            <form:textarea path="comment" type="number" cssClass="textfield textfield--shadow"/>

            <form:errors path="comment">
                <div class="alert alert--radius alert--red">
                    <form:errors path="comment" />
                </div>
            </form:errors>

            <form:label path="phone">Номер телефона</form:label>
            <form:input path="phone" cssClass="textfield textfield--shadow"/>

            <form:errors path="phone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="phone" />
                </div>
            </form:errors>

            <form:label path="address">Адрес</form:label>
            <form:input path="address" cssClass="textfield textfield--shadow"/>

            <form:errors path="address">
                <div class="alert alert--radius alert--red">
                    <form:errors path="address" />
                </div>
            </form:errors>

            <form:label path="prefix">Префикс</form:label>
            <form:input path="prefix" cssClass="textfield textfield--shadow"/>

            <form:errors path="prefix">
                <div class="alert alert--radius alert--red">
                    <form:errors path="prefix" />
                </div>
            </form:errors>

            <button class="button button--radius button--blue">
                    ${submitBtnText}
            </button>
        </form:form>
    </div>
</div>