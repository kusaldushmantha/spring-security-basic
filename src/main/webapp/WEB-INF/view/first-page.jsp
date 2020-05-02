<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  User: Kusal
  Date: 5/1/2020
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Security Demo</title>
</head>
<body>
<h1>First Page</h1>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout" />
</form:form>
</body>
</html>
