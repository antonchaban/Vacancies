<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 27.04.2021
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%--<section>
    <table border="1" width="100%" class="movies-table">
        <thead>
        <tr>
            <th>Vacancy</th>
            <th>Requirements</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="vacancy" items="${vacancies}">
            <tr>
                <td title="${vacancy.description}"><a href="vacancy?vacId=${vacancy.vacId}"><c:out value="${vacancy.vacName}"/></a></td>
                <td>
                    <c:if test="${vacancy.requirements.experience <= 0}">
                        <c:out value="No exp required"/>
                    </c:if>
                    <c:if test="${vacancy.requirements.experience > 0}">
                        <c:out value="Exp required: ${vacancy.requirements.experience} years"/>
                    </c:if>
                    </br>
                    <c:if test="${vacancy.requirements.highEducation}">
                        <c:out value="Higher education required"/>
                    </c:if>
                    <c:if test="${!vacancy.requirements.highEducation}">
                        <c:out value="Higher education not required"/>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vacancies</title>
    <%@include file="style.jspf" %>
</head>
<body>
<%@include file="header.jspf" %>
<c:forEach var="vacancy" items="${vacancies}">
    <div class="job-wrapper">
        <h1><a href="vacancy?vacId=${vacancy.vacId}"><c:out value="${vacancy.vacName}"/></a></h1>
        <hr>
        <ul class="requirements">
            <c:if test="${vacancy.requirements.experience <= 0}">
                <li>Job Experience: <span style="color: #22ff22"><c:out value="No exp required"/></span></li>
            </c:if>
            <c:if test="${vacancy.requirements.experience > 0}">
                <li>Job Experience: <span style="color: red"><c:out
                        value=" ${vacancy.requirements.experience} year(s)"/></span></li>
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
        <div class="more">
            <a href="vacancy?vacId=${vacancy.vacId}">See More</a>
        </div>

    </div>
</c:forEach>
<%@include file="footer.jspf" %>
</body>
</html>



