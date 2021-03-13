<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Данные клиента</jsp:attribute>
    <jsp:attribute name="content">
          <h1>Данные клиента</h1>
 <%@include file="../flash.jsp" %>


        <a href="/customer/${customerId}/deposit/new">Добавить залог</a>
        <br>
        <br>
          <table class="table">
              <thead class="table__head">
              <tr>
                  <th>Наименование</th>
                  <th>Прайс</th>
                  <th>Заметки</th>
                  <th>Комментарий</th>
                  <th>Редактировать</th>

              </tr>
              </thead>
              <tbody class="table__body">
              <c:forEach items="${deposit}" var="item">
                <tr>
                    <td>${item.title}</td>
                    <td>${item.price}</td>
                    <td>${item.notes}</td>
                    <td>${item.comment}</td>
                    <td>
                        <a href="/customer/${customerId}/deposit/${item.id}/edit">
                            Редактировать
                        </a>
                    </td>

                </tr>
          </c:forEach>
              </tbody>
          </table>
      </jsp:attribute>
</l:base>