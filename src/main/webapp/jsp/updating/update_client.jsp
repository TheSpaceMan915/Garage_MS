<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.person.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Database access--%>
<%
  List<Client> list_clients = DatabaseManager.getClients();
  request.setAttribute("clients", list_clients);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<%--  <script src = "../../scripts/validation_functions.js"></script>--%>
  <style>
    h1 {color: darkmagenta; text-align: center}

  </style>
    <title>Update Client</title>
</head>
<body>

<h1>Update a client</h1>

<form action="${pageContext.request.contextPath}/ServletController" method = "POST">
  <label for="select_client_id">Select a client</label><br>
  <select name="select_client" id="select_client_id">
    <c:forEach var="client" items="${clients}">
      <option value="${client.id}">${client.firstName} ${client.secondName}</option>
    </c:forEach>
  </select>
  <br><br>

  <p>Fill in the appropriate fields to update the data</p>
  <p>If you don't want to update some data, you should leave the appropriate field empty</p>

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

  <input type="hidden" name="action" value="Update a client">
  <br><input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>