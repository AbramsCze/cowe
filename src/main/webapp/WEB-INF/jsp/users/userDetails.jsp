<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cowe" tagdir="/WEB-INF/tags" %>

<cowe:layout pageName="users">

    <h2>User Information</h2>

    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><strong><c:out value="${user.firstName} ${user.lastName}"/></strong></td>
        </tr>
        <tr>
            <th>Login</th>
            <td><c:out value="${user.loginName}"/></td>
        </tr>
        <tr>
            <th>Pass</th>
            <td><c:out value="${user.password}"/></td>
        </tr>
    </table>

    <spring:url value="/users/{idUser}/edit" var="editUrl">
        <spring:param name="idUser" value="${user.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit User</a>

</cowe:layout>
