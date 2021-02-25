<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Добавить кассу</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Добавить Кассу</h1>
    <c:set var="submitBtnText" value="Добавить"/>
    <c:set var="submitAction" value="/superadmin/cashboxes/new"/>
    <%@include file="form.jsp" %>
    </jsp:attribute>

</l:base>