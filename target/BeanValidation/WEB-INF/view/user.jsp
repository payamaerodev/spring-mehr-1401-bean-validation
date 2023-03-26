<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
<h1>${user.name}</h1>
<%--<form:form action="processForm" method="post" modelAttribute="product">--%>
<%--    id : <form:input path="id" /><br>--%>
<%--    name : <form:input path="name" />--%>
<%--    <form:errors path="name" cssClass="error"/><br>--%>
<%--    description : <form:input path="description" /><br>--%>
<%--     price : <form:input path="price" />--%>
<%--    <form:errors path="price" cssClass="error"/><br>--%>
<%--    regx : <form:input path="regx" />--%>
<%--    <form:errors path="regx" cssClass="error"/><br>--%>


<%--    CouponCode : <form:input path="couponCode"/>--%>
<%--    <form:errors path="couponCode" cssClass="error"/><br>--%>
<%--    <input type="submit" value="send">--%>
<%--</form:form>--%>

${payam}
</body>
</html>
