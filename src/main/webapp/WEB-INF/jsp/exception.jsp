<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cowe" tagdir="/WEB-INF/tags" %>

<cowe:layout pageName="error">

    <spring:url value="/resources/images/greyson_logo.png" var="logoImage"/>
    <img src="${logoImage}"/>

    <h2>Ooups ... Something happened...</h2>

    <p>${exception.message}</p>

</cowe:layout>
