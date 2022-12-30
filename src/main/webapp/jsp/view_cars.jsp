<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="java.util.List" %>
<%@ page import="classes.car.Car" %>
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
  List<Car> list_cars = DatabaseManager.getCars();
  request.setAttribute("cars", list_cars);
%>

<html>
<head>
  <script>
    $(document).ready(function () {
      $('#table_cars').DataTable();
    });
  </script>
  <style>
    h1 {text-align: center}
    table {width: 100%}
  </style>
  <title>Cars</title>
</head>
<body>

<h1>Cars</h1>
<br>

<table id="table_cars" class="table table-bordered table-striped">
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
