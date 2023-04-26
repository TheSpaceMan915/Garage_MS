<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.appointment.ArchivedAppointment" %>
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
    List<ArchivedAppointment> list_archived_appointments = DatabaseManager.getArchivedAppointments();
    request.setAttribute("archived_appointments",list_archived_appointments);
%>

<html>
<head>
    <script>
        $(document).ready(function () {
            $('#table_archived_appointments').DataTable();
        });
    </script>
    <style>
        h1 {text-align: center}
        table {width: 100%}
    </style>
    <title>Archived appointments</title>
</head>
<body>

<h1>Archived appointments</h1>
<br>

<table id="table_archived_appointments" class="table table-bordered table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Service</th>
        <th scope="col">Mechanic</th>
        <th scope="col">Time</th>
        <th scope="col">Car plate number</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="archived_appointment" items="${archived_appointments}">
        <tr>
            <th scope="row">${archived_appointment.id}</th>
            <td>${archived_appointment.service.name}</td>
            <td>${archived_appointment.mechanic.firstName} ${archived_appointment.mechanic.secondName}</td>
            <td>${archived_appointment.appointmentTime}</td>
            <td>${archived_appointment.car.plateNumber}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
