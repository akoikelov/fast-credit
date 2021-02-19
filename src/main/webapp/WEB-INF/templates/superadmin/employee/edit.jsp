<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <l:base>
     <jsp:attribute name="title">Редактирование сотрудника</jsp:attribute>
      <jsp:attribute name="content">
          <h1>Редактировать сотрудника</h1>
          <c:set var="submitbtntext" value="Редактировать"/>
          <c:set var="submitAction" value="/superadmin/employees/${employeeId}/edit"/>
          <%@include file="editform.jsp"%>

      </jsp:attribute>
  </l:base>