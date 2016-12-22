<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="cowe" tagdir="/WEB-INF/tags" %>

<%@ attribute name="pageName" required="true" %>
<%@ attribute name="customScript" required="false" fragment="true"%>

<!doctype html>
<html>
<cowe:htmlHeader/>

<body>
<cowe:bodyHeader menuName="${pageName}"/>

<div class="container-fluid">
    <div class="container xd-container">

        <jsp:doBody/>
    </div>
</div>
<cowe:footer/>
<jsp:invoke fragment="customScript" />

</body>

</html>
