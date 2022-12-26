<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    h1 {color: coral; text-align: center}
  </style>
    <title>View data</title>
</head>
<body>

<h1>View Data</h1>

<p>What would you like to view?</p>
<ul>
  <li><a href="view_clients.jsp">Clients</a></li>
  <li><a href="view_cars.jsp">Cars</a></li>
  <li><a href="view_planned_appointments.jsp">Planned appointments</a></li>
  <li><a href="view_current_appointments.jsp">Current appointments</a></li>

</ul>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
