<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="java.util.List" %>
<%@ page import="classes.car.Car" %>
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
  List<Car> list_cars = DatabaseManager.getCars();
  request.setAttribute("cars", list_cars);
%>

<html>
<head>
  <style>
    h1 {text-align: center}
  </style>
  <title>Cars</title>
</head>
<body>

<h1>Cars</h1>
<br>

<table class="table table-bordered table-striped">
  <thead>
  <tr>
    <th scope="col">Id</th>
    <th scope="col">Brand</th>
    <th scope="col">Transmission</th>
    <th scope="col">Fuel</th>
    <th scope="col">Plate number</th>
    <th scope="col">Owner</th>
  </tr>
  </thead>
  <tbody>

  <c:forEach var="car" items="${cars}">
    <tr>
      <th scope="row">${car.id}</th>
      <td>${car.brand.name}</td>
      <td>${car.transmisson.type}</td>
      <td>${car.fuel.type}</td>
      <td>${car.plateNumber}</td>
      <td>${car.client.firstName} ${car.client.secondName}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
