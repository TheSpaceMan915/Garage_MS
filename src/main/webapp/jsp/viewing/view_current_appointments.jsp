<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.appointment.CurrentAppointment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--Libraries--%>
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"
        rel="stylesheet"
/>
<link
        href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"
        rel="stylesheet"
/>
<script
        type="text/javascript"
        src="https://code.jquery.com/jquery-3.5.1.js"
></script>
<script
        type="text/javascript"
        src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"
></script>
<script
        type="text/javascript"
        src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"
></script>

<%--Database access--%>
<%
    List<CurrentAppointment> list_current_appointments = DatabaseManager.getCurrentAppointments();
    request.setAttribute("current_appointments",list_current_appointments);
%>

<html>
<head>
    <script>
        $(document).ready(function () {
            $('#table_current_appointments').DataTable();
        });
    </script>
    <style>
        h1 {text-align: center}
        table {width: 100%}
    </style>
    <title>Current appointments</title>
</head>
<body>

<h1>Current appointments</h1>
<br>

<table id="table_current_appointments" class="table table-bordered table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Service</th>
        <th scope="col">Service state</th>
        <th scope="col">Mechanic</th>
        <th scope="col">Time</th>
        <th scope="col">Car plate number</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="current_appointment" items="${current_appointments}">
        <tr>
            <th scope="row">${current_appointment.id}</th>
            <td>${current_appointment.service.name}</td>
            <td>${current_appointment.serviceState.name}</td>
            <td>${current_appointment.mechanic.firstName} ${current_appointment.mechanic.secondName}</td>
            <td>${current_appointment.appointmentTime}</td>
            <td>${current_appointment.car.plateNumber}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
