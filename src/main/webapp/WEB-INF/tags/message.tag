<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<c:if test="${not empty error}">
    <p class="mb-20 error"><spring:message code="login.error" /></p>
</c:if>
<c:if test="${not empty msg}">
    <p class="mb-20"><spring:message code="login.logout" /></p>
</c:if>