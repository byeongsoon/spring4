<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2018. 6. 25.
  Time: PM 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title><spring:message code="member.register"/></title>
</head>
<body>
<%--<p><strong>${formData.name}님</strong>회원 가입을 완료했습니다.</p>--%>
<p>
  <spring:message code="register.done" arguments="${registerRequest.name},${registerRequest.name}"/>
</p>
<p>
  <a href="<c:url value='/main'/>">
    [<spring:message code="go.main"/>]
  </a>
</p>
</body>
</html>
