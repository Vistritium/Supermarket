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
<title>Supermarket "Janusz" - interaktywny katalog</title>
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
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nisl lectus, elementum at arcu vel, fermentum elementum magna. Pellentesque eget dui semper, luctus mi sit amet, rhoncus massa. Fusce libero nisl, pharetra at metus non, posuere hendrerit turpis. Quisque id justo vel metus luctus ullamcorper. Aenean at ante nec nisi rhoncus posuere. Pellentesque ipsum diam, sagittis id egestas fermentum, tempus in purus. Curabitur neque nisl, lobortis ac interdum vitae, pellentesque non urna. Integer fringilla eget risus vel rutrum.
		<br /><br />
		In ac neque magna. Maecenas ultrices gravida porttitor. Phasellus a est leo. Aliquam interdum eros eget est consequat sagittis. Nullam eu mi a nunc condimentum vehicula. Quisque hendrerit vitae velit eget facilisis. Nunc malesuada rutrum convallis. Integer in hendrerit mi. Maecenas tellus mauris, lobortis sit amet eleifend non, laoreet eget dui. Sed facilisis nisi nec gravida lobortis. Sed imperdiet urna dictum erat dictum sollicitudin.
		<br /><br />
		Proin dictum metus in sagittis varius. Aliquam erat mauris, porta a adipiscing at, aliquam ut tortor. Duis eros turpis, fringilla eget laoreet sed, convallis eget dui. Ut imperdiet luctus nunc sed sagittis. Suspendisse potenti. Phasellus luctus dolor neque, ac egestas purus condimentum vel. Aenean nec libero molestie, tristique elit quis, scelerisque mi. Donec interdum mi ac placerat malesuada. Ut at felis aliquam, dignissim lacus id, iaculis ante. Cras nec cursus arcu, vel elementum velit.
		</div>
		<div id="footer">
			<%out.print(PageView.RenderFooter()); %>
		</div>
	</div>



</body>
</html>
