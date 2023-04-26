<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.car.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="classes.service.Service" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Database access--%>
<%
    List<Car> list_cars = DatabaseManager.getCars();
    request.setAttribute("cars", list_cars);

    List<Service> list_services = DatabaseManager.getServices();
    request.setAttribute("services", list_services);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        h1 {color: darkorchid; text-align: center}
    </style>
    <title>Add Planned Appointment</title>
</head>
<body>

<h1>Add a planned appointment</h1>

<form action="${pageContext.request.contextPath}/ServletController" method = "POST">
    <label for="select_car_id">Select a car</label><br>
    <select name="select_car" id="select_car_id">
        <c:forEach var="car" items="${cars}">
        <option value="${car.id}">${car.plateNumber}</option>
        </c:forEach>
    </select>
    <br><br>

    <label for="select_service_id">Select a service</label><br>
    <select name="select_service" id="select_service_id">
        <c:forEach var="service" items="${services}">
            <option value="${service.id}">${service.name}</option>
        </c:forEach>
    </select>
    <br><br>

    <label for="time">Appointment time</label><br>
    <input type="datetime-local" id="time" name="field_time">
    <br><br>

    <input type="hidden" name="action" value="Create a planned appointment">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>