<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${flashSuccess != null}">
    <c:forEach items="${flashSuccess}" var="item">
        <div class="alert alert--radius alert--green">
            ${item}
        </div>
    </c:forEach>
</c:if>

<c:if test="${flashError != null}">
    <c:forEach items="${flashError}" var="item">
        <div class="alert alert--radius alert--red">
                ${item}
        </div>
    </c:forEach>
</c:if>