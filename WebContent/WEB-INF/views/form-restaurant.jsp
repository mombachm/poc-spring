<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Add Restaurants</h1>
<hr/>
<form:form modelAttribute="restaurant" servletRelativeAction="/add-restaurant" method="POST">
    <form:input class="form-control" path="id" type="hidden" value="${restaurant.id}"/>
    Name: <form:input path="name"/>
    <form:errors path="name"/><br/>
    Location: <form:input path="location"/>
    <form:errors path="location"/><br/>
    Average Price: <form:input path="averagePrice"/>
    <form:errors path="averagePrice"/><br/>
    Accept Alelo: <form:checkbox path="alelo" />
    <form:errors path="alelo"/><br/>
    Image: <form:input path="image" />
    <form:button id="saveButton">Save</form:button>
</form:form>
<button id="cancelButton" onclick="location.href='/'">Cancel</button>
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