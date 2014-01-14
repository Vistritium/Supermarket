
package webapp.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;





/* <<API>> Odkomentować by pobierać szablon danych z API */

import backend.api.WebApp;
import backend.core.model.Products;
import backend.core.model.Category;

/* <</API>> */




public class wDataManager implements wDatabaseConnector {

	public ArrayList<Products> ProductsList = new ArrayList<Products>();
	public ArrayList<Category> CategoryList = new ArrayList<Category>();
	
	public wDataManager() {
		//GenerateProductsList();			// <--- Pobiera dane lokalne
		/* <<API>> */
		GetProducts();			//<--- Pobiera dane z API
		/* <</API>> */
	}
	
	@Override
	public void GetProducts() {
		/* <<API>> */ 
		
			WebApp APIConn = new WebApp();
			
			this.ProductsList = (ArrayList<Products>) APIConn.getProducts();
			
			this.CategoryList = (ArrayList<Category>) APIConn.getCategory();
			
			
		/* <</API>> */
	}
	
	public String CategoryOf(Products Product) {
		for(int i = 0; i < CategoryList.size(); ++i) {
			if(Product.getCategory().getIdCategory() == i) { return CategoryList.get(i).getName(); }
			if(Product.getCategory().getIdCategory() == i) { return CategoryList.get(i).getName(); }
		}
		return "Brak kategorii";
	}
	
	
	public void sortLocalListBy (String Field, final int ascending) {
		
		
		switch(Field) {
		case "nazwa": // Nazwa
			Collections.sort(ProductsList, new Comparator<Products>() {
				@Override
				public int compare(Products o1, Products o2) {
					return o1.getName().compareTo(o2.getName()) * ascending;
				}
			});	
		break;
		case "kategoria": // Kategoria
			Collections.sort(ProductsList, new Comparator<Products>() {
				@Override
				public int compare(Products o1, Products o2) {
					String o1Cat = null, o2Cat = null;
					
					for(int i = 0; i < CategoryList.size(); ++i) {
						if(o1.getCategory().getIdCategory() == i) { o1Cat = CategoryList.get(i).getName(); }
						if(o2.getCategory().getIdCategory() == i) { o2Cat = CategoryList.get(i).getName(); }
					}
					return o1Cat.compareTo(o2Cat) * ascending;
				}
			});
		break;
		case "ilosc": // Ilość
			Collections.sort(ProductsList, new Comparator<Products>() {
				@Override
				public int compare(Products o1, Products o2) {
					if(o1.getCount() > o2.getCount()) {
						return 1 * ascending;
					} else {
						if(o1.getCount() < o2.getCount()) {
							return -1 * ascending;
						} else {
							return 0;
						}
					}
				
				}
			});
		break; 
		case "cena": // Cena
			Collections.sort(ProductsList, new Comparator<Products>() {
				@Override
				public int compare(Products o1, Products o2) {
					if(o1.getPrice() > o2.getPrice()) {
						return 1 * ascending;
					} else {
						if(o1.getPrice() < o2.getPrice()) {
							return -1 * ascending;
						} else {
							return 0;
						}
					}
				
				}
			});
		break;
		}
	}
	
	
	public void GenerateProductsList() {
		/*
		ProductsList.add(new webapp.core.Products("Chleb przeniczny", 0, 20, 3.20, 1));
		ProductsList.add(new webapp.core.Products("Chleb żytni", 0, 15, 4.0, 1));
		ProductsList.add(new webapp.core.Products("Mleko 'Łaciate'", 1, 80, 3.0, 1));
		ProductsList.add(new webapp.core.Products("Jogurt 'Danio'", 1, 230, 1.50, 1));
		ProductsList.add(new webapp.core.Products("Kurtka zimowa", 2, 5, 180, 1));
		ProductsList.add(new webapp.core.Products("Majtki", 2, 40, 20, 1));
		ProductsList.add(new webapp.core.Products("Klocki", 3, 10, 30, 1));
		ProductsList.add(new webapp.core.Products("Pluszak", 3, 17, 45, 1));
		
		
		CategoryList.add(new webapp.core.Category(0, "Pieczywo"));
		CategoryList.add(new webapp.core.Category(1, "Nabiał"));
		CategoryList.add(new webapp.core.Category(3, "Zabawki"));
		CategoryList.add(new webapp.core.Category(2, "Wyprzedaż"));
	*/
		
	}
	
	
}