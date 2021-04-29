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
        <form class="edit-form" action="vacsave" method="POST">
            <input type="hidden" name="vacId" value="${vacancy.vacId}">
            <div class="v-title-edit">
                Vacancy Title: <input type="text" name="vacName" required/>
            </div>
            <div class="v-description-edit"> Description:
                <textarea type="text" name="description" required></textarea>
            </div>
            <div class="v-exp-edit">
                Experience: <input type="number" name="exp"  required/>
            </div>
            <div class="v-education-edit">
                High Education: <input type="checkbox" name="highEducation"/>
            </div>
            <hr>
            <input class="more" id="save" type="submit" value="Save"/>

            </form>
    </div>
</div>
<%@include file="footer.jspf" %>
</body>
</html>
