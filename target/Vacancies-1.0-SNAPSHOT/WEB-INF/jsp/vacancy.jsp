<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 28.04.2021
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${vacancy.vacName}"/></title>
    <%@include file="style.jspf" %>
</head>
<body>
<%@include file="header.jspf" %>
<h1 align="center"><c:out value="${vacancy.vacName}"/></h1>
<hr>
<h4 align="center"><c:out value="${vacancy.description}"/></h4>
<hr>
<c:if test="${vacancy.requirements.experience <= 0}">
<h5><c:out value="No experience required"/></h5>
</c:if>
<c:if test="${vacancy.requirements.experience > 0}">
    <h5><c:out value="Experince required: ${vacancy.requirements.experience} years"/></h5>
</c:if>
</br>
<c:if test="${vacancy.requirements.highEducation}">
    <h5>  <c:out value="Higher education required"/></h5>
</c:if>
<c:if test="${!vacancy.requirements.highEducation}">
    <h5><c:out value="Higher education not required"/></h5>
</c:if>
<hr>
<c:if test="${vacancy.userId == user.userId}">
    <form action="vacedit" method="POST">
        <input type="hidden" name="vacId" value="${vacancy.vacId}">
        <button type="submit">EDIT</button>
    </form>
</c:if>
<%@include file="footer.jspf" %>
</body>
</html>
