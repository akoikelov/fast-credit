<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Добавление клиента</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Добавление клиента</h1>
        <c:set var="submitbtn" value="Добавить"/>
        <c:set var="submitAction" value="/customer/new"/>
        <%@include file="form.jsp"%>

    </jsp:attribute>

</l:base>
