<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.service.ServiceState" %>
<%@ page import="java.util.List" %>
<%@ page import="classes.appointment.CurrentAppointment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--Database access--%>
<%
    List<ServiceState> list_service_states = DatabaseManager.getServiceStates();
    request.setAttribute("service_states", list_service_states);

    List<CurrentAppointment> list_current_appointments = DatabaseManager.getCurrentAppointments();
    request.setAttribute("current_appointments",list_current_appointments);
%>

<html>
<head>
    <style>
        h1 {color: darkviolet; text-align: center}
    </style>
    <title>Change state</title>
</head>
<body>

<h1>Change the state of a service</h1>

<form action="${pageContext.request.contextPath}/ServletController" method = "POST">
    <label for="select_current_appointment_id">Select a car</label><br>
    <select name="select_current_appointment" id="select_current_appointment_id">
        <c:forEach var="current_appointment" items="${current_appointments}">
            <option value="${current_appointment.id}">${current_appointment.car.plateNumber}</option>
        </c:forEach>
    </select>
    <br><br>

    <label for="select_service_state_id">Select a service state</label><br>
    <select name="select_service_state" id="select_service_state_id">
        <c:forEach var="service_state" items="${service_states}">
            <option value="${service_state.id}">${service_state.name}</option>
        </c:forEach>
    </select>
    <br><br>

    <input type="hidden" name="action" value="Change state">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
