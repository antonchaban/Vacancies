<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 28.04.2021
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="Edit ${vacancy.vacName}"/></title>
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
<form class="edit-form" action="vacupdate" method="POST">
    <input type="hidden" name="vacId" value="${vacancy.vacId}">
    Vacancy Title: <input type="text" name="vacName" value="${vacancy.vacName}" required/>
    Description: <textarea type="text" name="description" required><c:out value="${vacancy.description}"/></textarea>
    Experience: <input type="number" name="exp" value="${vacancy.requirements.experience}" required/>
    High Education: <input type="checkbox" name="highEducation"
        <c:if test="${vacancy.requirements.highEducation}">
            checked
        </c:if> />
    <hr>
    <input id="update" type="submit" value="Update"/>
    <input id="delete" type="submit" value="Delete" formaction="vacdel"/>

</form>
<%@include file="footer.jspf" %>
</body>
</html>
