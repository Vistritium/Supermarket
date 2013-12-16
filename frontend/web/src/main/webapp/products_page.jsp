<%@page import="webapp.core.wDataManager"%>
<%@page import="webapp.core.wResourceManager"%>
<%@page import="webapp.core.wView"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	wView PageView = new wView("products_page.jsp", new wDataManager(), new wResourceManager("style.css"), null);
	
	if(request.getParameter("field") != null) {
		if(request.getParameter("ord").equals("d")) {
			PageView.DataManager.sortLocalListBy(request.getParameter("field"), -1);
			
		} else {	
			PageView.DataManager.sortLocalListBy(request.getParameter("field"), 1);
		}
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supermarket "Janusz" - Katalog produktów</title>
<link rel="stylesheet" type="text/css" href="<% out.print(PageView.ResourceManager.getStylesheet()); %>" />
<link href='http://fonts.googleapis.com/css?family=Mouse+Memoirs&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
</head>
<body>

	<div id="master">
		<div id="header">
				LOGO SUPERMARKETU<br /><br /><br /><br /><br /><br /><br /><br />	
		</div>
		<div id="menubar">
			<a href="index.jsp" class="menuItem" id="return">&lt; Strona główna</a>
			<a href="sale_page.jsp" class="menuItem">Oferta sezonowa</a>
			<a href="contact.jsp" class="menuItem">Kontakt</a>
		</div>
		<div id="content">
			<table id="products">
			<%	
			 	
				int sales = PageView.DataManager.ProductsList.size();
				
				if(sales == 0) {
					out.print("<div class='message' id='error'>Brak aktywnych wyprzedaży.</div>");
				} else {
					out.print("<tr><th>Nazwa:" + PageView.RenderSortButtons("nazwa") + "</th><th>Kategoria:" + PageView.RenderSortButtons("kategoria") + "</th><th>Cena:" + PageView.RenderSortButtons("cena") + "</th><th>Ilość:" + PageView.RenderSortButtons("ilosc") + "</th></tr>");
					for(int i = 0; i < sales; i++) {
						out.print("<tr>");
							out.print("<td>");
							out.print(PageView.DataManager.ProductsList.get(i).getName());
							out.print("</td>");
							out.print("<td>");
							out.print(PageView.DataManager.CategoryOf(PageView.DataManager.ProductsList.get(i)));
							out.print("</td>");
							out.print("<td>");
							out.print(PageView.DataManager.ProductsList.get(i).getPrice());
							out.print("</td>");
							out.print("<td>");
							out.print(PageView.DataManager.ProductsList.get(i).getCount());
							out.print("</td>");
						out.print("</tr>");	
					}
				}
				
			%>
			</table>
		</div>
		<div id="footer">
			Autorzy:<br /><br />
			Michał Owczarczyk <br />
			Sylwia Doryń
		</div>
	</div>



</body>
</html>
