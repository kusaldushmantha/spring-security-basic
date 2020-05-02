<%--
  User: Kusal
  Date: 5/1/2020
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Security Demo</title>
</head>
<body>
<h1>Home Page</h1>

<hr>
<p><label>USER : <security:authentication property="principal.username"/></label></p>
<p><label>ROLE(s) : <security:authentication property="principal.authorities"/></label></p>
<hr>

<security:authorize access="hasRole('MANAGER')">
    <hr>
    <p><a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> ( Managers Only )</p>
    <hr>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <hr>
    <p><a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> ( Admin Only )</p>
    <hr>
</security:authorize>


<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout"/>
</form:form>

</body>
</html>
