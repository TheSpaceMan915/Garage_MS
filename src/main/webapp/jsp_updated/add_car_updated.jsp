<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.person.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="classes.car.CarBrand" %>
<%@ page import="classes.car.Transmission" %>
<%@ page import="classes.car.Fuel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%--Database access--%>
<%
  List<Client> list_clients = DatabaseManager.getClients();
  request.setAttribute("clients", list_clients);

  List<CarBrand> list_brands = DatabaseManager.getCarBrands();
  request.setAttribute("brands", list_brands);

  List<Transmission> list_transmissions = DatabaseManager.getTransmissions();
  request.setAttribute("transmissions", list_transmissions);

  List<Fuel> list_fuels = DatabaseManager.getFuels();
  request.setAttribute("fuels", list_fuels);
%>

<%--<sql:query var="clients" dataSource="${dataSource}">SELECT * FROM client;</sql:query>--%>
<%--<sql:query var="brands" dataSource="${dataSource}">SELECT * FROM car_brand;</sql:query>
<sql:query var="transmissions" dataSource="${dataSource}">SELECT * FROM transmission;</sql:query>
<sql:query var="fuels" dataSource="${dataSource}">SELECT * FROM fuel;</sql:query>--%>
<!DOCTYPE html>
<html>
<head>
  <script src = "../scripts/validation_functions.js"></script>
  <style>
    h1 {color: blueviolet; text-align: center}
  </style>
    <title>Add a car</title>
</head>
<body>

<h1>Add a car</h1>

<form action="${pageContext.request.contextPath}/ServletController" onsubmit="return checkAddCar()" method = "POST">
  <label for="select_client">Select a client</label><br>
  <select name="select_client" id="select_client">
    <c:forEach var="client" items="${clients}">
      <option value="${client.id}">${client.firstName} ${client.secondName}</option>
    </c:forEach>
  </select>
  <br><br>

  <label for="plate_number">Plate number</label><br>
  <input type="text" id="plate_number" name="field_plate_number">
  <br>
  <p id="notification_plate_number"></p>
  <br>

  <label for="select_brand_id">Select a car brand</label><br>
  <select name="select_brand" id="select_brand_id">
    <c:forEach var="brand" items="${brands}">
      <option value="${brand.id}">${brand.name}</option>
    </c:forEach>
  </select>
  <br><br>

  <label for="select_transmission_id">Select a transmission type</label><br>
  <select name="select_transmission" id="select_transmission_id">
    <c:forEach var="transmission" items="${transmissions}">
      <option value="${transmission.id}">${transmission.type}</option>
    </c:forEach>
  </select>
  <br><br>

  <label for="select_fuel_id">Select a fuel type</label><br>
  <select name="select_fuel" id="select_fuel_id">
    <c:forEach var="fuel" items="${fuels}">
      <option value="${fuel.id}">${fuel.type}</option>
    </c:forEach>
  </select>
  <br><br>

  <input type="hidden" name="action" value="Add a new car">
  <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>