<%@page import="webapp.core.wDataManager"%>
<%@page import="webapp.core.wResourceManager"%>
<%@page import="webapp.core.wView"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	wView PageView = new wView("contact.jsp", new wDataManager(), new wResourceManager("style.css"), null);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supermarket "Janusz" - formularz kontaktowy</title>
<link rel="stylesheet" type="text/css" href="resources/style.css" />
<link href='http://fonts.googleapis.com/css?family=Mouse+Memoirs&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
</head>
<body>

	<div id="master">
		<div id="header">
				LOGO SUPERMARKETU<br /><br /><br /><br /><br /><br /><br /><br />	
		</div>
		<div id="menubar">
			<a href="index.jsp" class="menuItem" id="return">&lt; Strona główna</a>
			<a href="products_page.jsp" class="menuItem">Produkty</a>
			<a href="sale_page.jsp" class="menuItem">Oferta sezonowa</a>
		</div>
		<div id="content">
		
			<div id="contact-area">
			
			<form method="post" action="contactengine.php">
				<label for="Name">Imię:</label>
				<input type="text" name="Name" id="Name" />
				
				<label for="Name">Nazwisko:</label>
				<input type="text" name="Surame" id="Name" />
				
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
			Autorzy:<br /><br />
			Michał Owczarczyk <br />
			Sylwia Doryń
		</div>
	</div>



</body>
</html>
