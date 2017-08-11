<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Where to lunch? - Login</title>
</head>
<body>

<h2 id="headerText" class="header">Where to lunch, CD?</h2>
<hr>
<br>

<div  class="container form-signin">
    <br>
    <h1>Log in</h1>
    <form:form class="form-signin" modelAttribute="user" servletRelativeAction="/" method="POST">
        <div class="form-group">
            Email:    <form:input class="form-control" path="email" id="loginEmail"/>
            <form:errors path="email"/>
        </div>
        <div class="form-group">
            Password: <form:password class="form-control" path="password" id="loginPassword"/>
            <form:errors path="password"/>
        </div>
        <c:if test="${param.error == 'true'}">
            <div class="form-group">
                <span style="color: crimson">Login error, please verify your entries</span>
            </div>
        </c:if>
        <div class="form-group">
            <form:button role="button" class="form-control btn btn-primary">Login</form:button>
        </div>
    </form:form>
    <a style="font-size: smaller">Don't have an account?</a>
    <button role="button" class="btn btn-primary" onclick="location.href='registration'">Register now!</button>
</div>

</body>
</html>