<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <br>
    <br>
    <br>
    <c:if test="${paginationpages>1}">
        <ul class="pager">
            <c:forEach begin="1" end="${paginationpages}" var="index">
                <li>
                    <a href="?page=${index}" class="pager__page"> ${index}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</div>