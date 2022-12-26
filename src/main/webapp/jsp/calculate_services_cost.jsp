<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.car.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--Database access--%>
<%
        List<Car> list_cars = DatabaseManager.getCars();
        request.setAttribute("cars", list_cars);
%>

<html>
<head>
    <style>
        h1 {color: darkorchid; text-align: center}
    </style>
    <title>Services cost</title>
</head>
<body>

<h1>Calculate the cost of services</h1>

<form action="${pageContext.request.contextPath}/ServletController" method = "POST">
    <label for="select_car_id">Select a car</label><br>
    <select name="select_car" id="select_car_id">
        <c:forEach var="car" items="${cars}">
            <option value="${car.id}">${car.plateNumber}</option>
        </c:forEach>
    </select>
    <br><br>

    <input type="hidden" name="action" value="Services cost">
    <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
