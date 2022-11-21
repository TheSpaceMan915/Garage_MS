<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src = "../scripts/validation_functions.js"></script>
    <style>
        h1 {color: darkorchid; text-align: center}
    </style>
    <title>Services cost</title>
</head>
<body>

<h1>Calculate the cost of services</h1>

<form action="${pageContext.request.contextPath}/ServletController" onsubmit="return checkCalculateServicesCost()" method = "POST">
    <label for="car_id">Car id</label><br>
    <input type="text" id="car_id" name="field_car_id">
    <br>
    <p id="notification_car_id"></p>
    <br>

    <input type="hidden" name="action" value="Services cost">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
