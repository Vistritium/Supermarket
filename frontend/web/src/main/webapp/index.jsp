<%@page import="webapp.core.wDataManager"%>
<%@page import="webapp.core.wResourceManager"%>
<%@page import="webapp.core.wView"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

	wView PageView = new wView("contact.jsp", null, new wResourceManager("modern.css"), null);

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supermarket - interaktywny katalog</title>
<link rel="stylesheet" type="text/css" href="<% out.print(PageView.ResourceManager.getStylesheet()); %>" />
<link href='http://fonts.googleapis.com/css?family=Alegreya+Sans+SC' rel='stylesheet' type='text/css'>
</head>
<body>

	<div id="master">
		<div id="header">
				<img src="resources/modern/logo.png"/>	<% out.print(PageView.RenderContactInfo()); %>
		</div>
		<div id="menubar">
			<a href="products_page.jsp" class="menuItem" id="left">Produkty</a>
			<a href="sale_page.jsp" class="menuItem" id="middle">Oferta sezonowa</a>
			<a href="contact.jsp" class="menuItem" id="right">Kontakt</a>
		</div>
		<div id="content">
		Witamy na stronie naszego supermarketu!</br></br>
		Korzystając z niniejszej strony internetowej możesz sprawdzić ofertę naszego sklepu, przejrzeć aktualne wyprzedaże oraz skontaktować się z nami poprzez formularz kontaktowy.</br></br>
		Zapraszamy do przeglądania.
		</div>
		<div id="footer">
			<%out.print(PageView.RenderFooter()); %>
		</div>
	</div>



</body>
</html>
