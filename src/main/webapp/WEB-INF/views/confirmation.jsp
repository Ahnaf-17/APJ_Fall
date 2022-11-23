<%--
  Created by IntelliJ IDEA.
  User: Ahnaf Ahmed
  Date: 11/24/2022
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>

<h1>Confirmation</h1>

<c:out value="${student.firstname}" />
<br><br>
<c:out value="${student.lastname}" />

<hr>

<p>Welcome, ${user.email} ${user.password}</p>

</body>
</html>
