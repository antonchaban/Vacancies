<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 28.04.2021
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creating Vacancy</title>
    <%@include file="style.jspf" %>
    <style>
        textarea {
            width: 400px;
            height: 100px;
            resize: none;
        }
    </style>
</head>
<body>
<%@include file="header.jspf" %>
<form class="edit-form" action="vacsave" method="POST">
    <input type="hidden" name="vacId" value="${vacancy.vacId}">
    Vacancy Title: <input type="text" name="vacName" placeholder="Vacancy Title" required/>
    Description: <textarea type="text" name="description" required placeholder="Vacancy Description"></textarea>
    Experience: <input type="number" name="exp" placeholder="Experience" required/>
    High Education: <input type="checkbox" name="highEducation"/>
    <hr>
    <input id="save" type="submit" value="Save"/>

</form>
<%@include file="footer.jspf" %>
</body>
</html>
