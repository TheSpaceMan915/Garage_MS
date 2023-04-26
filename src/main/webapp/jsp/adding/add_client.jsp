<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <script src = "../../scripts/validation_functions.js"></script>
  <style>
    h1 {color: darkmagenta; text-align: center}

  </style>
    <title>Add Client</title>
</head>
<body>

<h1>Add a client</h1>

<form action="${pageContext.request.contextPath}/ServletController" onsubmit="return checkAddClient()" method = "POST">
  <label for="first_name">First name</label><br>
  <input type="text" id="first_name" name="field_first_name">
  <br>
  <p id="notification_first_name"></p>
  <br>

  <label for="second_name">Second name</label><br>
  <input type="text" id="second_name" name="field_second_name">
  <br>
  <p id="notification_second_name"></p>
  <br>

  <label for="phone_number">Phone number</label><br>
  <input type="text" id="phone_number" name="field_phone_number">
  <br>
  <p id="notification_phone_number"></p>
  <br>

  <input type="hidden" name="action" value="Add a new client">
  <br><input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>