<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cowe" tagdir="/WEB-INF/tags" %>

<cowe:layout pageName="users">
    <h2>Users</h2>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Login</th>
                <th>Password</th>
            </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <spring:url value="/users/{userId}.html" var="userUrl">
                <spring:param name="userId" value="${user.loginName}"/>
            </spring:url>
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><a href="${fn:escapeXml(userUrl)}"><c:out value="${user.firstName} ${user.lastName}"/></a></td>
                <td><c:out value="${user.loginName}"/></td>
                <td><c:out value="${user.password}"/></td>
            </tr>
        </c:forEach>
    </table>

    <spring:url value="/user/new.html" var="addUrl" />
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New User</a>

</cowe:layout>
