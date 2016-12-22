<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cowe" tagdir="/WEB-INF/tags" %>

<cowe:layout pageName="users">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                console.log("Custom javascript");
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>
            <c:if test="${user['new']}">New </c:if> User
        </h2>
        <form:form modelAttribute="user" class="form-horizontal">
            <input type="hidden" name="id" value="${user.id}"/>
            <div class="form-group has-feedback">
                <cowe:inputField label="FirstName" name="firstName"/>
                <cowe:inputField label="LastName" name="lastName"/>
                <cowe:inputField label="LoginName" name="loginName"/>
                <cowe:inputField label="Password" name="password"/>
                <%--<div class="control-group">--%>
                    <%--<cowe:selectField name="type" label="Type " names="${types}" size="5"/>--%>
                <%--</div>--%>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${user['new']}">
                            <button class="btn btn-default" type="submit">Add User</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Update User</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
        <c:if test="${!user['new']}">
        </c:if>
    </jsp:body>
</cowe:layout>
