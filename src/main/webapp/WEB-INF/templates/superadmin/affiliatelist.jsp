<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Список филиалов</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Список филиалов</h1>

        <a class="button button--orange" href="/superadmin/affiliates/new">Добавить филиал</a>
        <br><br>

        <%@include file="../flash.jsp" %>

        <table class="table">
            <thead class="table__head">
            <tr>
                <th class="table__sort--desc" sortable="true">Название</th>
                <th>Макс сумма (при ежедневной оплате)</th>
                <th>Макс сумма (при ежемесячной оплате)</th>
                <th></th>
            </tr>
            </thead>
            <tbody class="table__body">
            <c:forEach items="${affiliates}" var="item">
                <tr>
                    <td>${item.title}</td>
                    <td>${item.maxSumDay}</td>
                    <td>${item.maxSumMonth}</td>
                    <td>
                        <a href="/superadmin/affiliates/${item.id}/edit">
                            Редактировать
                        </a>
                    </td>
                </tr>
          </c:forEach>
            </tbody>
        </table>
        <div class="content__wrapper">
            <a class="button button--green" href="?pagination=10">10 элементов</a>
            <a class="button button--red"href="?pagination=20">20 элементов</a>
            <a class="button button--blue"href="?pagination=30">30 элементов</a>

        </div>
        <div>
            <br>
            <br>
            <br>
            <c:if test="${paginationpages > 1}">
        <ul class="pager">
            <c:forEach begin="1" end="${paginationpages}" var="index">
                <li>
                    <a href="?page=${index}" class="pager__page"> ${index}</a>
                </li>
            </c:forEach>
        </ul>
            </c:if>
        </div>
    </jsp:attribute>

</l:base>