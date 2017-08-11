<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register.css" type="text/css"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
    <title>Where to lunch, CD? - Register</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

<div class="container form-signin">
    <h2>Welcome. Please register</h2>

    <form:form class="form-signin" modelAttribute="user" servletRelativeAction="/registration" method="POST">
        <div class="form-group">
            Name: <form:input path="name" id="userName" class="form-control"/>
            <form:errors path="name"  class="errors"/>
        </div>
        <div class="form-group">
            Email: <form:input path="email" class="form-control"/>
            <form:errors path="email"  class="errors"/>
        </div>
        <div class="form-group">
            Date of birth: <form:input  path="dateOfBirth" format="dd/MM/yyyy" class="form-control"/>
            <form:errors path="dateOfBirth"  class="errors"/>
        </div>
        <div class="form-group">
            Password: <form:password path="password" class="form-control"/>
            <form:errors path="password"  class="errors"/>
        </div>
        <div class="form-group">
            Confirm password: <form:password path="passwordConfirm" class="form-control"/>
            <form:errors path="passwordConfirm"  class="errors"/>
        </div>
        <form:hidden path="id"  />
        <input class="btn btn-primary" type="submit" name="action" value="Register" />
        <button role="button" class="btn btn-primary" onclick="window.location='/';return false;">Cancel</button>
    </form:form>
</div>
</body>


</html>