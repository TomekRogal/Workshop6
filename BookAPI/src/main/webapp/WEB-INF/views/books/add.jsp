<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<h1>Add Book:</h1>
<form:form method="post"
           modelAttribute="book">
    <form:hidden path="id"/>
    Title: <form:input path="title" /> <br>
    <form:errors path="title"/><br>
    Isbn: <form:input path="isbn" /> <br>
    <form:errors path="isbn"/><br>
    Author: <form:input path="author" /> <br>
    <form:errors path="author"/><br>
    Publisher: <form:input path="publisher" /> <br>
    <form:errors path="publisher"/><br>
    Type: <form:input path="type" /> <br>
    <form:errors path="type"/><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>