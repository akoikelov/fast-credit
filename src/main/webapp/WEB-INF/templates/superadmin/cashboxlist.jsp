<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>

<l:base>
    <jsp:attribute name="title">Add new client</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Cashbox List</h1>
         <a class="button button--orange" href="/superadmin/cashboxes/new">Добавить кассу</a>
     <br><br>
        <%@include file="../flash.jsp" %>
        <table class="table">
            <thead class="table__head">
            <tr>
                <th>Название кассы</th>
                <th>Номер филиала</th>
                <th>Комментарий</th>
                <th>Редактировать</th>
            </tr>
            </thead>
            <tbody class="table__body">
            <c:forEach items="${cashbox}" var="item">
        <tr>
            <td>${item.title}</td>
            <td>${item.affiliate.title}</td>
            <td>${item.comment}</td>
            <td><a href="/superadmin/cashboxes/${item.id}/edit" >Редактировать</a></td>

        </tr>
          </c:forEach>
            </tbody>
        </table>
        <div class="content__wrapper">
            <a class="button button--green" href="?pagination=10">10 элементов</a>
            <a class="button button--red"href="?pagination=20">20 элементов</a>
            <a class="button button--blue"href="?pagination=30">30 элементов</a>

        </div>


        <%@include file="../pagination.jsp" %>
    </jsp:attribute>

</l:base>