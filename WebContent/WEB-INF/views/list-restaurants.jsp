<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list-restaurant.css" type="text/css"/>
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
    <h2>Where to lunch?</h2>
    <br>
    <div class="card-deck">
        <c:forEach var="restaurant" items="${restaurants}">
            <div class="card" style="width: 300px;">
                <c:choose>
                    <c:when test="${not empty restaurant.image}">
                        <img style="max-height:100%; max-width: 100%;" class="img-responsive" src="${restaurant.image}" alt="Card image cap">
                    </c:when>
                    <c:otherwise>
                        <img style="max-height:100%; max-width: 100%;" class="img-responsive" src="http://www.nutrienteaf.com/wp-content/uploads/2015/10/cardapioicone.png" alt="Card image cap">
                    </c:otherwise>
                </c:choose>
                <div class="card-block">
                    <h4 class="card-title">${restaurant.name}</h4>
                    <p class="card-text">Average Price: R$${restaurant.averagePrice}</p>
                    <c:choose>
                        <c:when test="${restaurant.alelo}">
                            <img style="width: 70px; height: auto;" class="img-responsive" src="https://www.meualelo.com.br/saldo_extrato/images/alelo-logo.png"/>
                        </c:when>
                        <c:otherwise>
                            <img style="opacity: 0.1; width: 70px; height: auto;" class="img-responsive" src="https://www.meualelo.com.br/saldo_extrato/images/alelo-logo.png"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="card-footer text-center">
                    <a href="${restaurant.location}" class="btn btn-primary">
                        <img class="imgIcon" src="http://flaticons.net/icons/Miscellaneous/Maps.png" />
                    </a>

                    <a href="<c:url value="/edit-restaurant">
                        <c:param name="id" value="${restaurant.id}" />
                    </c:url>" class="btn btn-primary">
                        <img class="imgIcon" src="http://flaticons.net/icons/User%20Interface/Report-Editor.png"/>
                    </a>
                    <a href="#" onclick="location.href='remove-restaurant?id='+${restaurant.id}" class="btn btn-primary">
                        <img class="imgIcon" src="http://www.flaticons.net/icons/Office/Delete.png"/>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
    <br>
    <a class="btn btn-primary" href="<c:url value="/add-restaurant" />">Add Restaurant</a>
    <a class="btn btn-primary" href="<c:url value="/votings" />">Votings</a>
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