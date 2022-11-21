<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src = "../scripts/validation_functions.js"></script>
    <style>
        h1 {color: darkviolet; text-align: center}
    </style>
    <title>Change state</title>
</head>
<body>

<h1>Change the state of a service</h1>

<form action="${pageContext.request.contextPath}/ServletController" onsubmit="return checkChangeServiceState()" method = "POST">
    <label for="current_appointment_id">Current appointment id</label><br>
    <input type="text" id="current_appointment_id" name="field_current_appointment_id">
    <br>
    <p id="notification_current_appointment_id"></p>
    <br>

    <label for="select_service_state_id">Select a service state</label><br>
    <select name="select_service_state" id="select_service_state_id">
        <option value="1">In progress</option>
        <option value="2">Finished</option>
    </select>
    <br><br>

    <input type="hidden" name="action" value="Change state">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
