<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Список залогов</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Список залогов</h1>

        <a class="button button--orange" href="/customer/new">Добавить клиента</a>
        <br><br>

        <%@include file="../flash.jsp" %>

        <table class="table">
            <thead class="table__head">
            <tr>
                <th class="table__sort--desc" sortable="true">ФИО</th>
                <th>Дата Рождения</th>
                <th>Паспорт. данные</th>
                <th>Адрес</th>
                <th>Телефон</th>
                <th>Тел для СМС</th>
                <th>Пени?</th>
                <th>В черном списке?</th>
                <th>Редактировать</th>
            </tr>
            </thead>
            <tbody class="table__body">
            <c:forEach items="${customers}" var="item">
                <tr>
                    <td>${item.fullName}</td>
                    <td>${item.birthday}</td>
                    <td>${item.passportId}</td>
                    <td>${item.address}</td>
                    <td>${item.phone}</td>
                    <td>${item.smsPhone}</td>
                    <td>${item.fineEnabled}</td>
                    <td>${item.blackList}</td>
                    <td>
                        <a href="/customer/${item.id}/edit">
                            Редактировать
                        </a>
                    </td>
                </tr>
          </c:forEach>
            </tbody>
        </table>
        <div class="content__wrapper">
            <a class="button button--green" href="?pagination=10">10 элементов</a>
            <a class="button button--red" href="?pagination=20">20 элементов</a>
            <a class="button button--blue" href="?pagination=30">30 элементов</a>

        </div>
        <%@include file="../pagination.jsp" %>
    </jsp:attribute>

</l:base>
