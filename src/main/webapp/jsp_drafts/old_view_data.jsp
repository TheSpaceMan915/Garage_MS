<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        h1 {color: darkmagenta; text-align: center}
    </style>
    <title>View</title>
</head>
<body>

<h1>View Data</h1>
<label for="chooser">Choose what you'd like to view</label>

<form action="${pageContext.request.contextPath}/ServletController" method = "POST">
    <select name="list" id="chooser">
    <option value="Clients">Clients</option>
    <option value="Cars">Cars</option>
    <option value="Planned appointments">Planned appointments</option>
    <option value="Current appointments">Current appointments</option>
    </select>
    <input type="hidden" name="action" value="View">
    <br><input type="submit" value="Submit">
</form>
<br><br>

<button type="button" name="back" onclick="history.back()">Go back</button>

</body>
</html>