<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Список сотрудников</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Список сотрудников</h1>
         <a class="button button--orange" href="/superadmin/employees/new">Добавить сотрудника</a>
        <br><br>
        <%@include file="../flash.jsp" %>
        <table class="table">
            <thead class="table__head">
            <tr>
                <th class="table__sort--desc" sortable="true">Логин</th>
                <th>ФИО</th>
                <th>Зарплата</th>
                <th>День рождение</th>
                <th>Телефон</th>
                <th>Редактировать</th>
            </tr>
            </thead>
            <tbody class="table__body">
            <c:forEach items="${employees}" var="item">
        <tr>
            <td>${item.userName}</td>
            <td>${item.fullName}</td>
            <td>${item.salary}</td>
            <td>${item.birthday}</td>
            <td>${item.phone}</td>
            <td><a href="/superadmin/employees/${item.id}/edit" >Редактировать</a></td>

        </tr>
          </c:forEach>
            </tbody>
        </table>
        <div class="content__wrapper">
            <a class="button button--green" href="?pagination=10">10 элементов</a>
            <a class="button button--red"href="?pagination=20">20 элементов</a>
            <a class="button button--blue"href="?pagination=30">30 элементов</a>

        </div>
<<<<<<< Updated upstream


        <%@include file="../pagination.jsp" %>
=======
        <div>
            <br>
            <br>
            <br>
            <c:if test="${paginationpages>1}">
        <ul class="pager">
            <c:forEach begin="1" end="${paginationpages}" var="index">
                <li>
                    <a href="?${queryParams}page=${index}" class="pager__page"> ${index}</a>
                </li>
            </c:forEach>
        </ul>
            </c:if>
        </div>
>>>>>>> Stashed changes
    </jsp:attribute>

</l:base>