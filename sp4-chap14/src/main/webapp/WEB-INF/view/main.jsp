<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>메인</title>
</head>
<body>
<c:if test="${empty authInfo}">
  <p>
    <a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
    <a href="<c:url value="/login"/>">로그인</a>
  </p>
</c:if>
<c:if test="${! empty authInfo}">
  <a href="<c:url value="/edit/changePassword" />">[비밀번호 변경]</a>
  <a href="<c:url value="/logout"/>">로그아웃</a>
</c:if>
</body>
</html>
