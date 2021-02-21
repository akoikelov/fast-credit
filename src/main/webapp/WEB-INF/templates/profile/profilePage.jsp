<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<l:base>
    <jsp:attribute name="title">Изменение профиля</jsp:attribute>
    <jsp:attribute name="content">
        <h1>Изменение профиля</h1>
    <c:set var="submitBtnText" value="Изменить"/>
    <c:set var="submitAction" value="/profile"/>
    <%@include file="editformprofile.jsp" %>
    </jsp:attribute>

</l:base>