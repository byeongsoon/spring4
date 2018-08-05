<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title><spring:message code="change.pwd.title"/></title>
</head>
<body>
<form:form>
  <p>
    <label>
      <spring:message code="currentPassword"/>:<br>
      <form:password path="currentPassword"/>
      <form:errors path="currentPassword"/>
    </label>
  </p>
  <p>
    <label>
      <spring:message code="newPassword"/>:<br>
      <form:password path="newPassword"/>
      <form:errors path="newPassword"/>
    </label>
  </p>
  <input type="submit" value="<spring:message code="change.btn" />">
</form:form>
</body>
</html>
