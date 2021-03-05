<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="card card--blue">
    <div class="card__content">
        <c:set var="now" value="<% = new java.util.Date()%>"/>
        <form:form method="POST"
                   action="${submitAction}" modelAttribute="customer" cssClass="form">
            <form:label path="fullName">ФИО</form:label>
            <form:input path="fullName" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="fullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="fullName"/>
                </div>
            </form:errors>
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
            <form:input path="address" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="address">
                <div class="alert alert--radius alert--red">
                    <form:errors path="address"/>
                </div>
            </form:errors>


            <form:label path="phone">Телефон</form:label>
            <form:input path="phone" type="text"
                        cssClass="textfield textfield--shadow"/>
            <form:errors path="phone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="phone"/>
                </div>
            </form:errors>


            <form:label path="smsPhone">Тел для СМС</form:label>
            <form:input path="smsPhone" type="number" cssClass="textfield textfield--shadow"/>
            <form:errors path="smsPhone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="smsPhone"/>
                </div>
            </form:errors>

            <form:label path="fineEnabled">Пени</form:label>
            <form:checkbox value="0" path="fineEnabled"/>

            <form:errors path="fineEnabled">
                <div class="alert alert--radius alert--red">
                    <form:errors path="fineEnabled"/>
                </div>
            </form:errors>
            <br>
            <br>
            <form:label path="blackList">Черный список</form:label>
            <form:checkbox value="0" path="blackList"/>

            <form:errors path="blackList">
                <div class="alert alert--radius alert--red">
                    <form:errors path="blackList"/>
                </div>
            </form:errors>

            <br>
            <br>
            <form:label path="comment">Комментарий</form:label>
            <form:textarea path="comment" cssClass="textfield textfield--shadow"/>
            <form:errors path="comment">
                <div class="alert alert--radius alert--red">
                    <form:errors path="comment"/>
                </div>
            </form:errors>

            <form:label path="note">Заметки</form:label>
            <form:input path="note" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="note">
                <div class="alert alert--radius alert--red">
                    <form:errors path="note"/>
                </div>
            </form:errors>

            <form:label path="weeksNote">Заметки по дням неделям</form:label>
            <form:textarea path="weeksNote" cssClass="textfield textfield--shadow"/>
            <form:errors path="weeksNote">
                <div class="alert alert--radius alert--red">
                    <form:errors path="weeksNote"/>
                </div>
            </form:errors>

            <form:label path="taxiCompany">Таксопарк</form:label>
            <form:input path="taxiCompany" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="taxiCompany">
                <div class="alert alert--radius alert--red">
                    <form:errors path="taxiCompany"/>
                </div>
            </form:errors>

            <form:label path="bortNumber">Борт</form:label>
            <form:input path="bortNumber" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="bortNumber">
                <div class="alert alert--radius alert--red">
                    <form:errors path="bortNumber"/>
                </div>
            </form:errors>


            <form:label path="shift">Смена</form:label>
            <form:input path="shift" cssClass="textfield textfield--shadow"/>
            <form:errors path="shift">
                <div class="alert alert--radius alert--red">
                    <form:errors path="shift"/>
                </div>
            </form:errors>

            <form:label path="placeOfBirth">Место рождения</form:label>
            <form:input path="placeOfBirth" cssClass="textfield textfield--shadow"/>
            <form:errors path="placeOfBirth">
                <div class="alert alert--radius alert--red">
                    <form:errors path="placeOfBirth"/>
                </div>
            </form:errors>

            <form:label path="maritalStatus">Семейное положение</form:label>
            <form:select path="maritalStatus" cssClass="select select--radius">
                <form:options items="${customer.marital}"/>
            </form:select>
            <form:errors path="maritalStatus">
                <div class="alert alert--radius alert--red">
                    <form:errors path="maritalStatus"/>
                </div>
            </form:errors>

            <form:label path="partnerFullName">ФИО супрга(и)</form:label>
            <form:input path="partnerFullName" cssClass="textfield textfield--shadow"/>
            <form:errors path="partnerFullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="partnerFullName"/>
                </div>
            </form:errors>

            <form:label path="partnerWorkplace">Место работы супрга(и)</form:label>
            <form:input path="partnerWorkplace" cssClass="textfield textfield--shadow"/>
            <form:errors path="partnerWorkplace">
                <div class="alert alert--radius alert--red">
                    <form:errors path="partnerWorkplace"/>
                </div>
            </form:errors>


            <form:label path="partnerPhone">Телефон супрга(и)</form:label>
            <form:input path="partnerPhone" cssClass="textfield textfield--shadow"/>
            <form:errors path="partnerPhone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="partnerPhone"/>
                </div>
            </form:errors>

            <form:label path="brotherPhone">Телефон брата)</form:label>
            <form:input path="brotherPhone" cssClass="textfield textfield--shadow"/>
            <form:errors path="brotherPhone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="brotherPhone"/>
                </div>
            </form:errors>

            <form:label path="sisterPhone">Телефон сестры</form:label>
            <form:input path="sisterPhone" cssClass="textfield textfield--shadow"/>
            <form:errors path="sisterPhone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="sisterPhone"/>
                </div>
            </form:errors>

            <form:label path="motherPhone">Телефон мамы</form:label>
            <form:input path="motherPhone" cssClass="textfield textfield--shadow"/>
            <form:errors path="motherPhone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="motherPhone"/>
                </div>
            </form:errors>

            <form:label path="fatherPhone">Телефон отца</form:label>
            <form:input path="fatherPhone" cssClass="textfield textfield--shadow"/>
            <form:errors path="fatherPhone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="fatherPhone"/>
                </div>
            </form:errors>

            <form:label path="roommatePhone">Телефон сожителя</form:label>
            <form:input path="roommatePhone" cssClass="textfield textfield--shadow"/>
            <form:errors path="roommatePhone">
                <div class="alert alert--radius alert--red">
                    <form:errors path="roommatePhone"/>
                </div>
            </form:errors>


            <form:label path="motherFullName">ФИО мамы</form:label>
            <form:input path="motherFullName" cssClass="textfield textfield--shadow"/>
            <form:errors path="motherFullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="motherFullName"/>
                </div>
            </form:errors>


            <form:label path="fatherFullName">ФИО папы</form:label>
            <form:input path="fatherFullName" cssClass="textfield textfield--shadow"/>
            <form:errors path="fatherFullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="fatherFullName"/>
                </div>
            </form:errors>


            <form:label path="sisterFullName">ФИО сестры</form:label>
            <form:input path="sisterFullName" cssClass="textfield textfield--shadow"/>
            <form:errors path="sisterFullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="sisterFullName"/>
                </div>
            </form:errors>


            <form:label path="brotherFullName">ФИО брата</form:label>
            <form:input path="brotherFullName" cssClass="textfield textfield--shadow"/>
            <form:errors path="brotherFullName">
                <div class="alert alert--radius alert--red">
                    <form:errors path="brotherFullName"/>
                </div>
            </form:errors>


            <form:label path="parentWorkPlace">Место работы родителей</form:label>
            <form:input path="parentWorkPlace" cssClass="textfield textfield--shadow"/>
            <form:errors path="parentWorkPlace">
                <div class="alert alert--radius alert--red">
                    <form:errors path="parentWorkPlace"/>
                </div>
            </form:errors>


            <form:label path="workPlace">Место работы</form:label>
            <form:select path="workPlace" cssClass="select select--radius">
                <form:options items="${customer.workPlaces}"/>
            </form:select>
            <form:errors path="workPlace">
                <div class="alert alert--radius alert--red">
                    <form:errors path="workPlace"/>
                </div>
            </form:errors>


            <form:label path="workPlaceMore">Место работы (подробнее)</form:label>
            <form:input path="workPlaceMore" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="workPlaceMore">
                <div class="alert alert--radius alert--red">
                    <form:errors path="workPlaceMore"/>
                </div>
            </form:errors>

            <form:label path="numberOfChildren">Кол-во детей</form:label>
            <form:input path="numberOfChildren" type="number" cssClass="textfield textfield--shadow"/>
            <form:errors path="numberOfChildren">
                <div class="alert alert--radius alert--red">
                    <form:errors path="numberOfChildren"/>
                </div>
            </form:errors>


            <form:label path="actualAddress">Фактический адрес</form:label>
            <form:textarea path="actualAddress" cssClass="textfield textfield--shadow"/>
            <form:errors path="actualAddress">
                <div class="alert alert--radius alert--red">
                    <form:errors path="actualAddress"/>
                </div>
            </form:errors>


            <form:label path="relativesPhones">Телефоны родных(близких)</form:label>
            <form:input path="relativesPhones" cssClass="textfield textfield--shadow"/>
            <form:errors path="relativesPhones">
                <div class="alert alert--radius alert--red">
                    <form:errors path="relativesPhones"/>
                </div>
            </form:errors>


            <form:label path="daysSalaryLevel">Уровень зарплаты в день</form:label>
            <form:input path="daysSalaryLevel" type="number" cssClass="textfield textfield--shadow"/>
            <form:errors path="daysSalaryLevel">
                <div class="alert alert--radius alert--red">
                    <form:errors path="daysSalaryLevel"/>
                </div>
            </form:errors>


            <form:label path="otherIncome">Прочие доходы</form:label>
            <form:input path="otherIncome" cssClass="textfield textfield--shadow"/>
            <form:errors path="otherIncome">
                <div class="alert alert--radius alert--red">
                    <form:errors path="otherIncome"/>
                </div>
            </form:errors>


            <form:label path="monthlyPayments">Ежемесячные платежи</form:label>
            <form:input path="monthlyPayments" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="monthlyPayments">
                <div class="alert alert--radius alert--red">
                    <form:errors path="monthlyPayments"/>
                </div>
            </form:errors>


            <form:label path="ownership">Наличие собственности</form:label>
            <form:input path="ownership" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="ownership">
                <div class="alert alert--radius alert--red">
                    <form:errors path="ownership"/>
                </div>
            </form:errors>


            <form:label path="receivedCreditBefore">Получал ли кредит раньше</form:label>
            <form:input path="receivedCreditBefore" type="text" cssClass="textfield textfield--shadow"/>
            <form:errors path="receivedCreditBefore">
                <div class="alert alert--radius alert--red">
                    <form:errors path="receivedCreditBefore"/>
                </div>
            </form:errors>


            <form:label path="isArrested">На аресте?</form:label>
            <form:checkbox value="0" path="isArrested"/>

            <form:errors path="isArrested">
                <div class="alert alert--radius alert--red">
                    <form:errors path="isArrested"/>
                </div>
            </form:errors>

            <form:label path="regularComment">Комментарии(регулярные)</form:label>
            <form:textarea path="regularComment" type="number" cssClass="textfield textfield--shadow"/>
            <form:errors path="regularComment">
                <div class="alert alert--radius alert--red">
                    <form:errors path="regularComment"/>
                </div>
            </form:errors>


            <%--            <form:label path="disableFineTillDate">Отключить пени до</form:label>--%>
            <%--            <form:input path="disableFineTillDate" type="date" cssClass="textfield textfield--shadow"/>--%>
            <%--            <form:errors path="disableFineTillDate">--%>
            <%--                <div class="alert alert--radius alert--red">--%>
            <%--                    <form:errors path="disableFineTillDate"/>--%>
            <%--                </div>--%>
            <%--            </form:errors>--%>


            <button class="button button--radius button--blue">
                    ${submitbtn}
            </button>
        </form:form>
    </div>
</div>
