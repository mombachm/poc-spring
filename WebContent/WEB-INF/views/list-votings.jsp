<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <h2>Votings</h2>
    <br>
    <div class="card-deck">
        <c:forEach var="voting" items="${votings}" >
            <div class="card" style="width: 300px;" onclick="location.href='voting?id='+${voting.id}">
                <div class="card-block">
                    <h4 class="card-title">${voting.name}</h4>
                </div>
            </div>
        </c:forEach>
    </div>
    <br>
    <a class="btn btn-primary" href="<c:url value="/start-voting" />">Start New Voting</a>
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