<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.appointment.ArchivedAppointment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Font Awesome -->
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
        rel="stylesheet"
/>
<!-- Google Fonts -->
<link
        href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
        rel="stylesheet"
/>
<!-- MDB -->
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.1/mdb.min.css"
        rel="stylesheet"
/>
<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.1/mdb.min.js"
></script>

<%--Database access--%>
<%
    List<ArchivedAppointment> list_archived_appointments = DatabaseManager.getArchivedAppointments();
    request.setAttribute("archived_appointments",list_archived_appointments);
%>

<html>
<head>
    <style>
        h1 {text-align: center}
    </style>
    <title>Archived appointments</title>
</head>
<body>

<h1>Archived appointments</h1>
<br>

<table class="table table-bordered table-striped">
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
