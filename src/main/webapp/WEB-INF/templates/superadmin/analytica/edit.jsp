<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Редактирование аналитики</jsp:attribute>
    <jsp:attribute name="content">
          <h1>Редактирование аналитики</h1>
          <c:set var="submitbtnText" value="Редактировать"/>
          <c:set var="submitAction" value="/superadmin/analytics/${analyticsId}/edit"/>
          <%@include file="form.jsp" %>

      </jsp:attribute>
</l:base>
