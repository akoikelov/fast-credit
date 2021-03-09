<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Редактирование клиента</jsp:attribute>
    <jsp:attribute name="content">
          <h1>Редактировать клиента</h1>
          <c:set var="submitbtn" value="Редактировать"/>
          <c:set var="submitAction" value="/customer/${customerId}/edit"/>
          <%@include file="form.jsp" %>

      </jsp:attribute>
</l:base>