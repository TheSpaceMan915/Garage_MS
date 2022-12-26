<%@ page import="classes.appointment.PlannedAppointment" %>
<%@ page import="java.util.List" %>
<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.person.Mechanic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Database access--%>
<%
    List<PlannedAppointment> list_planned_appointments = DatabaseManager.getPlannedAppointments();
    request.setAttribute("planned_appointments",list_planned_appointments);

    List<Mechanic> list_mechanics = DatabaseManager.getMechanics();
    request.setAttribute("mechanics", list_mechanics);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        h1 {color: blueviolet; text-align: center}
    </style>
    <title>Add Current Appointment</title>
</head>
<body>

<h1>Add a current appointment</h1>

<form action="${pageContext.request.contextPath}/ServletController"  method = "POST">
    <label for="select_planned_appointment_id">Select a planned appointment</label><br>
    <select name="select_planned_appointment" id="select_planned_appointment_id">
        <c:forEach var="planned_appointment" items="${planned_appointments}">
            <option value="${planned_appointment.id}">${planned_appointment.appointmentTime}</option>
        </c:forEach>
    </select>
    <br><br>

<!-- use the select element because there might be more than one mechanic working at the garage -->
    <label for="select_mechanic_id">Select a mechanic</label><br>
    <select name="select_mechanic" id="select_mechanic_id">
        <c:forEach var="mechanic" items="${mechanics}">
            <option value="${mechanic.id}">${mechanic.firstName} ${mechanic.secondName}</option>
        </c:forEach>
    </select>
    <br><br>

    <input type="hidden" name="action" value="Create a current appointment">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>