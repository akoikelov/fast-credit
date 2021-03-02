<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>

<l:base>
    <jsp:attribute name="title">Список Аналитики</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Список Аналитики</h1>
         <a class="button button--orange" href="/superadmin/analytics/new">Добавить аналитику</a>
        <br><br>
        <%@include file="../flash.jsp" %>
        <table class="table">
            <thead class="table__head">
            <tr>
                <th class="table__sort--desc" sortable="true">Наименование</th>
                <th>Комментарий</th>
                <th>Тип</th>
                <th>Редактировать</th>
            </tr>
            </thead>
            <tbody class="table__body">
            <c:forEach items="${analytics}" var="item">
        <tr>
            <td>${item.title}</td>
            <td>${item.comment}</td>
            <td>${item.isIncome ? 'приход' : 'расход' }</td>
            <td><a href="/superadmin/analytics/${item.id}/edit">Редактировать</a></td>

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
