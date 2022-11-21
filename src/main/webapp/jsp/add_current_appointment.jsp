<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src = "../scripts/validation_functions.js"></script>
    <style>
        h1 {color: blueviolet; text-align: center}
    </style>
    <title>Add Current Appointment</title>
</head>
<body>

<h1>Add a current appointment</h1>

<form action="${pageContext.request.contextPath}/ServletController" onsubmit="return checkAddCurrentAppointment()" method = "POST">
    <label for="planned_appointment_id">Planned appointment id</label><br>
    <input type="text" id="planned_appointment_id" name="field_planned_appointment_id">
    <br>
    <p id="notification_planned_appointment_id"></p>
    <br>

<!-- use the select element because there might be more than one mechanic working at the garage -->
    <label for="select_mechanic_id">Select a mechanic</label><br>
    <select name="select_mechanic" id="select_mechanic_id">
        <option value="1">Rudolf Diesel</option>
    </select>
    <br><br>

    <input type="hidden" name="action" value="Create a current appointment">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>