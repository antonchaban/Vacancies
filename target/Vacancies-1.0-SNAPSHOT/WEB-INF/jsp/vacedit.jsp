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
        <form class="edit-form" action="vacupdate" method="POST">
            <input type="hidden" name="vacId" value="${vacancy.vacId}">
            <div class="v-title-edit">
                Vacancy Title: <input type="text" name="vacName" value="${vacancy.vacName}" required/>
            </div>
            <div class="v-description-edit"> Description:
                <textarea type="text" name="description" required><c:out value="${vacancy.description}"/></textarea>
            </div>
            <div class="v-exp-edit">
                Experience: <input type="number" name="exp" value="${vacancy.requirements.experience}" required/>
            </div>
            <div class="v-education-edit">
                High Education: <input type="checkbox" name="highEducation"
                    <c:if test="${vacancy.requirements.highEducation}">
                        checked
                    </c:if> />
            </div>
            <hr>
            <input class="more" id="update" type="submit" value="Update"/>
            <input class="more" id="delete" type="submit" value="Delete" formaction="vacdel"/>

            </form>
        </form>
    </div>
<%@include file="footer.jspf" %>
</body>
</html>
