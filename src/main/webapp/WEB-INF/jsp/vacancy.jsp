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
    <style>
        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
        }
    </style>
</head>
<body>
<%@include file="header.jspf" %>
<div class="vacinfo-center">
    <div class="vacinfo-wrapper">
        <h1 align="center"><c:out value="${vacancy.vacName}"/></h1>
        <hr>
        <ul class="requirements">
            <c:if test="${vacancy.requirements.experience <= 0}">
                <li>Job Experience: <span style="color: #22ff22"><c:out value="No exp required"/></span></li>
            </c:if>
            <c:if test="${vacancy.requirements.experience > 0}">
                <li>Job Experience: <span style="color: red"><c:out
                        value="Exp required: ${vacancy.requirements.experience} years"/></span></li>
            </c:if>
            <c:if test="${vacancy.requirements.highEducation}">
                <li>Higher Education: <span style="color: red"><c:out value="Required"/></span></li>
            </c:if>
            <c:if test="${!vacancy.requirements.highEducation}">
                <li>Higher Education: <span style="color: #22ff22"><c:out value="Not Required"/></span></li>
            </c:if>
            <li class="description">
                <c:out value="${vacancy.description}"/>
            </li>
        </ul>
        <c:if test="${vacancy.userId == user.userId}">
            <form action="vacedit" method="POST">
                <input type="hidden" name="vacId" value="${vacancy.vacId}">
                <button class="more" type="submit">EDIT</button>
            </form>
        </c:if>
    </div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>
