<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src = "../scripts/validation_functions.js"></script>
    <style>
        h1 {color: darkorchid; text-align: center}
    </style>
    <title>Add Planned Appointment</title>
</head>
<body>

<h1>Add a planned appointment</h1>

<form action="${pageContext.request.contextPath}/ServletController" onsubmit="return checkAddPlannedAppointment()" method = "POST">
    <label for="car_id">Car id</label><br>
    <input type="text" id="car_id" name="field_car_id">
    <br>
    <p id="notification_car_id"></p>
    <br>

    <label for="time">Appointment time</label><br>
    <input type="datetime-local" id="time" name="field_time">
    <br><br>

    <label for="select_service_id">Select a service</label><br>
    <select name="select_service" id="select_service_id">
        <option value="1">Oil filter change</option>
        <option value="2">Wiper blades replacement</option>
        <option value="3">Spark plug replacement</option>
        <option value="4">Air filter change</option>
        <option value="5">Oxygen sensor replacement</option>
        <option value="6">Brakes replacement</option>
        <option value="7">Transmission inspection</option>
        <option value="8">Fuel cap tightening</option>
    </select>
    <br><br>

    <input type="hidden" name="action" value="Create a planned appointment">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>