<%--
  Created by IntelliJ IDEA.
  User: Ahnaf Ahmed
  Date: 10/28/2022
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Confiramtion</title>
</head>
<body>

<h1>Confirmation</h1>

<c:out value="${message}" />

<hr>

<p>Welcome, ${user.email} ${user.password}</p>

</body>
</html>
