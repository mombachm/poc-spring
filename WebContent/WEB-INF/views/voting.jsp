<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<a class="btn btn-primary" href="<c:url value="/logoutSpring" />">Logout</a>
<div class="container">
    <br>
    <br>
    <h2>Voting: ${voting.name}</h2>
    <br>
    <form:form modelAttribute="vote" servletRelativeAction="/vote" method="POST">
        <form:input class="form-control" path="id" type="hidden" value="${vote.id}"/>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Average Price</th>
                    <th>Alelo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="restaurant" items="${restaurants}">
                    <tr>
                        <td><h5>${restaurant.name}</h5></td>
                        <td>R$${restaurant.averagePrice}</td>
                        <td>
                            <c:choose>
                                <c:when test="${restaurant.alelo}">
                                    <img style="width: 70px; height: auto;" class="img-responsive" src="https://www.meualelo.com.br/saldo_extrato/images/alelo-logo.png"/>
                                </c:when>
                                <c:otherwise>
                                    <img style="opacity: 0.1; width: 70px; height: auto;" class="img-responsive" src="https://www.meualelo.com.br/saldo_extrato/images/alelo-logo.png"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td><form:radiobutton path="restaurant.id" value="${restaurant.id}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form:input class="form-control" path="voting.id" type="hidden" value="${voting.id}"/>
        <form:button role="button" href="#" class="btn btn-primary" id="voteButton">Vote</form:button>
    </form:form>
    <br>
    <a class="btn btn-primary" href="<c:url value="/votings" />">Back to votings</a>


    <h2>Vote History</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>User</th>
            <th>Restaurant</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vote" items="${votes}">
            <tr>
                <td><h5>${vote.user.name}</h5></td>
                <td>${vote.restaurant.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    /*$( ".removeButton" ).click(function(event) {
        var target = $( event.target );
        target.parent().parent().remove();
    });*/
</script>
</body>
</html>