<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/form-restaurant.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<div class="container">
    <br>
    <c:choose>
        <c:when test="${restaurant.id == 0}">
            <h1>Add Restaurant</h1>
        </c:when>
        <c:otherwise>
            <h1>Edit Restaurant</h1>
        </c:otherwise>
    </c:choose>
    <hr/>
        <form:form modelAttribute="restaurant" servletRelativeAction="/add-restaurant" method="POST">
            <div class="form-group">
                <form:input class="form-control" path="id" type="hidden" value="${restaurant.id}"/>
                Name: <form:input class="form-control"  path="name"/>
                <form:errors path="name"/>
            </div>
            <div class="form-group">
                Location: <form:input class="form-control"  path="location"/>
                <form:errors path="location"/>
            </div>
            <div class="form-group">
                Average Price: <form:input class="form-control"  path="averagePrice"/>
                <form:errors path="averagePrice"/>
            </div>
            <div class="form-check">
                <label> Accept Alelo: <form:checkbox  path="alelo"/></label>
                <form:errors path="alelo"/>
            </div>
            <div class="form-group">
                Image: <form:input class="form-control"  path="image" />
                <form:errors path="image"/>
            </div>
            <form:button role="button" href="#" class="form-control btn btn-primary" id="saveButton">Save</form:button>
        </form:form>
        <button href="#" role="button" id="cancelButton" class="form-control btn btn-primary" onclick="location.href='/restaurants'">Cancel</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    /*$(function() {
        $("saveButton").prop('disabled', false);
    });

    $( "#checkRoomButton" ).click(function(event) {
        var sRoom = $("roomName").value();
        $.get("/isBooked?name="+sRoom).done(function (response) {
            $("saveButton").prop('disabled', true);
        }).fail(function () {
            $("saveButton").prop('disabled', false);
        });
    });*/
</script>
</body>
</html>