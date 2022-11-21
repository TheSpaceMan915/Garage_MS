<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <label for="client_id">Client id</label><br>
  <input type="text" id="client_id" name="field_client_id">
  <br>
  <p id="notification_client_id"></p>
  <br>


  <label for="plate_number">Plate number</label><br>
  <input type="text" id="plate_number" name="field_plate_number">
  <br>
  <p id="notification_plate_number"></p>
  <br>

  <label for="select_brand_id">Select a car brand</label><br>
  <select name="select_brand" id="select_brand_id">
    <option value="1">BMW</option>
    <option value="2">Mercedes</option>
    <option value="3">Mitsubishi</option>
    <option value="4">Tesla</option>
    <option value="5">Ferrari</option>
    <option value="6">Ford</option>
    <option value="7">Porsche</option>
    <option value="8">Toyota</option>
  </select>
  <br><br>

  <label for="select_transmission_id">Select a transmission type</label><br>
  <select name="select_transmission" id="select_transmission_id">
    <option value="1">Continuously variable</option>
    <option value="2">Manual</option>
    <option value="3">Automatic</option>
    <option value="4">Semi-automatic</option>
    <option value="5">Dual-clutch</option>
  </select>
  <br><br>

  <label for="select_fuel_id">Select a fuel type</label><br>
  <select name="select_fuel" id="select_fuel_id">
    <option value="1">Petrol</option>
    <option value="2">Diesel</option>
    <option value="3">Bio-diesel</option>
    <option value="4">Gas</option>
    <option value="5">Electricity</option>
  </select>
  <br><br>

  <input type="hidden" name="action" value="Add a new car">
  <input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>