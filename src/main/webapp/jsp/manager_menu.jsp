<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        h1 {color: orangered; text-align: center}
    </style>
    <title>Manager menu</title>
</head>
<body>

<h1>Manager Menu</h1>

<ul>
    <li><a href="jsp/view_data.jsp">View data</a></li>
    <li><a href="jsp/add_client.jsp">Add a new client</a></li>
    <li><a href="jsp/add_car.jsp">Add a new car</a></li>
    <li><a href="jsp/add_planned_appointment.jsp">Add a planned appointment</a></li>
    <li><a href="jsp/add_current_appointment.jsp">Add a current appointment</a></li>
</ul>
<br><br>


<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
