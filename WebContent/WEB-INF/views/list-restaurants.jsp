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
<table border="1">
    <tr>
        <th>Name</th>
        <th>Location</th>
        <th>Average Price</th>
        <th>Accept Alelo</th>
    </tr>
    <c:forEach var="restaurant" items="${restaurants}">
        <tr>
            <td>${restaurant.name}</td>
            <td>${restaurant.location}</td>
            <td>${restaurant.averagePrice}</td>
            <td>${restaurant.alelo}</td>
            <td><img src="${restaurant.image}" alt=""></td>
            <td><button class="removeButton"  onclick="location.href='remove-restaurant?id='+${restaurant.id}" href="">Remove</button>
            <td><button class="editButton"  onclick="location.href='edit-restaurant?id='+${restaurant.id}" href="">Edit</button>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add" onclick="location.href='add-restaurant'">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    /*$( ".removeButton" ).click(function(event) {
        var target = $( event.target );
        target.parent().parent().remove();
    });*/
</script>
</body>
</html>