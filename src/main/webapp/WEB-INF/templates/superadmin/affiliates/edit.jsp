<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>

    <jsp:attribute name="title">Редактировать филиал</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Редактировать филиал</h1>

        <c:set var="submitBtnText" value="Редактировать" /> <!-- создаю переменные которые используются в form.jsp -->
        <c:set var="submitAction" value="/superadmin/affiliates/${affiliateId}/edit" />

        <%@include file="form.jsp" %> <!-- подключить шаблон form.jsp сюда -->

    </jsp:attribute>

</l:base>