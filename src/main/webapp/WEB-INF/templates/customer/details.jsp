<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Данные клиента</jsp:attribute>
    <jsp:attribute name="content">
          <h1>Данные клиента</h1>
 <%@include file="../flash.jsp"%>

        <a href="/customer/${customerId}/deposit/new" >Добавить залог</a>
      </jsp:attribute>
</l:base>