<%@ page import="classes.others.DatabaseManager" %>
<%@ page import="classes.person.Client" %>
<%@ page import="java.util.List" %>
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
    List<Client> list_clients = DatabaseManager.getClients();
    request.setAttribute("clients", list_clients);
%>

<html>
<head>
    <style>
        h1 {text-align: center}
    </style>
    <title>Clients</title>
</head>
<body>

<h1>Clients</h1>
<br>

<table class="table table-bordered table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">First name</th>
        <th scope="col">Second name</th>
        <th scope="col">Phone number</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="client" items="${clients}">
        <tr>
            <th scope="row">${client.id}</th>
            <td>${client.firstName}</td>
            <td>${client.secondName}</td>
            <td>${client.phoneNumber}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>
