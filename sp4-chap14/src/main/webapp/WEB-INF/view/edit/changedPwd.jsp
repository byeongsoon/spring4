<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><spring:message code="change.pwd.title"/></title>
</head>
<body>
<p>
  <spring:message code="change.pwd.done"/>
</p>
<p>
  <a href="<c:url value='/main'/>">
    [<spring:message code="go.main" />]
  </a>
</p>
</body>
</html>
