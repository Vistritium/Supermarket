<%@page import="webapp.core.wDataManager"%>
<%@page import="webapp.core.wResourceManager"%>
<%@page import="webapp.core.wView"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	wView PageView = new wView("sale_page.jsp", new wDataManager(), new wResourceManager("modern.css"), null);
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
<title>Supermarket - okazje sezonowe</title>
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
			<a href="contact.jsp" class="menuItem" id="right">Kontakt</a>
		</div>
		<div id="content">
		<table id="products">
			<%	
			int sales = 0;
			int items = PageView.DataManager.ProductsList.size();
			
				for(int i = 0; i < items; i++) {
					if(PageView.DataManager.CategoryOf(PageView.DataManager.ProductsList.get(i)).toLowerCase() == "wyprzedaż") {
						sales++;
						if(sales == 1) {
							out.print("<tr><th>Nazwa:" + PageView.RenderSortButtons("nazwa") + "</th><th>Cena:" + PageView.RenderSortButtons("cena") + "</th><th>Ilość:" + PageView.RenderSortButtons("ilosc") + "</th></tr>");
						}
						out.print("<tr>");
							out.print("<td>");
							out.print(PageView.DataManager.ProductsList.get(i).getName());
							out.print("</td>");
							out.print("<td>");
							out.print(PageView.DataManager.ProductsList.get(i).getPrice() + " zł");
							out.print("</td>");
							out.print("<td>");
							out.print(PageView.DataManager.ProductsList.get(i).getCount());
							out.print("</td>");
						out.print("</tr>");	
					}
				}
				//	out.print(sales);
				if(sales == 0) {
					out.print("<div class='message'>Brak aktywnych wyprzedaży</div>");
				}
			%>
		</table>
		</div>
		<div id="footer">
			<%out.print(PageView.RenderFooter()); %>
		</div>
	</div>



</body>
</html>
