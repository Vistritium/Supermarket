<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>My Title</title>
</head>
<body>
<% java.util.Date d = new java.util.Date(); %>

<h1>
Testowa strona dla: Supermarket <small><%= d.toString() %></small><br />
<br />

</h1>
</body>
</html>