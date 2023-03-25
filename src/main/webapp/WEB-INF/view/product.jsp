<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>

<form:form action="processForm" method="post" modelAttribute="product">
<%--    id : <form:input path="id" /><br>--%>
<%--    name : <form:input path="name" />--%>
<%--    <form:errors path="name" cssClass="error"/><br>--%>
<%--    description : <form:input path="description" /><br>--%>
<%--     price : <form:input path="price" />--%>
<%--    <form:errors path="price" cssClass="error"/><br>--%>
<%--    regx : <form:input path="regx" />--%>
    price : <form:input path="format" />
<h1><spring:message code="welcome.title" text="Welcome" /></h1>
    <form:errors path="format" cssClass="error"/><br>
    <input type="submit" value="send">
</form:form>
</body>
</html>
