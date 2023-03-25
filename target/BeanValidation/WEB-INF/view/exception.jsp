<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>

<form:form action="processForm" method="post">
<h1>be khata khordim ${message}</h1>

</form:form>
</body>
</html>