<%@page import="webapp.core.wDataManager"%>
<%@page import="webapp.core.wValidator"%>
<%@page import="webapp.core.wResourceManager"%>
<%@page import="webapp.core.wView"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	wView PageView = new wView("contact.jsp", null, new wResourceManager("modern.css"), new wValidator());

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supermarket - formularz kontaktowy</title>
<link rel="stylesheet" type="text/css" href="<% out.print(PageView.ResourceManager.getStylesheet()); %>" />
<link href='http://fonts.googleapis.com/css?family=Alegreya+Sans+SC' rel='stylesheet' type='text/css'>
</head>
<body>

	<div id="master">
		<div id="header">
				<img src="resources/modern/logo.png"/><% out.print(PageView.RenderContactInfo()); %>	
		</div>
		<div id="menubar">
			<a href="index.jsp" class="menuItem" id="return">&lt; Strona główna</a>
			<a href="products_page.jsp" class="menuItem" id="middle">Produkty</a>
			<a href="sale_page.jsp" class="menuItem" id="right">Oferta sezonowa</a>
		</div>
		<div id="content">
		
		<%
		if("POST".equals(request.getMethod())) {
			String output = PageView.Validator.isValid(request.getParameter("Name"), request.getParameter("Surname"), request.getParameter("City"), request.getParameter("Email"), request.getParameter("Message"));
			if(output.compareTo("valid") == 0) {
				PageView.ResourceManager.SendMail("Wiadomość od klienta:" + request.getParameter("Name") + " " + request.getParameter("Surname"), "Dane klienta:\r\nImię: " + request.getParameter("Name") + "\r\nNazwisko: " + request.getParameter("Surname") + "\r\nMiasto: " + request.getParameter("City") + "\r\nE-mail: " + request.getParameter("Email") + "\r\n\r\n Wiadomość: \r\n" + request.getParameter("Message"));
				out.print("<div class='message' id='success'>Wiadomość została wysłana</div>");
			} else {
				out.print("<div class='message' id='error'>" + output + "</div>");
			}
		}
		%>
			<div id="contact-area">
			
			<form method="post" action="contact.jsp">
				<label for="Name">Imię:</label>
				<input type="text" name="Name" id="Name" />
				
				<label for="Name">Nazwisko:</label>
				<input type="text" name="Surname" id="Name" />
				
				<label for="City">Adres:</label>
				<input type="text" name="City" id="City" />
	
				<label for="Email">E-mail:</label>
				<input type="text" name="Email" id="Email" />
				
				<label for="Message">Wiadomość:</label><br />
				<textarea name="Message" rows="20" cols="20" id="Message"></textarea>

				<input type="submit" name="submit" value="Wyślij" class="submit-button" />
			</form>
			
			</div>
			
		</div>
		<div id="footer">
			<%out.print(PageView.RenderFooter()); %>
		</div>
	</div>



</body>
</html>
