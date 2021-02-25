<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Изменение кассы</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Изменение кассы</h1>
    <c:set var="submitBtnText" value="Изменить"/>
    <c:set var="submitAction" value="/superadmin/cashboxes/${cashboxid}/edit"/>
    <%@include file="form.jsp" %>
    </jsp:attribute>

</l:base>