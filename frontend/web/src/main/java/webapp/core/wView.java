package webapp.core;

import java.util.Calendar;


public class wView {
	
	public String Filename;
	public wDataManager DataManager;
	public wResourceManager ResourceManager;
	public wValidator Validator;
	
	public wView(String Filename, wDataManager DataManager, wResourceManager ResourceManager, wValidator Validator) {
		this.Filename = Filename;
		this.DataManager = DataManager;
		this.ResourceManager = ResourceManager;
		this.Validator = Validator;
	}
	
	public void ProcessRequest(String Field, String order) {
		
	}
	
	// Renders
	
	public String RenderSortButtons(String Field) {
		
		return "<div class='sortbuttons'><a href='" + this.Filename + "?field=" + Field + "&ord=a'> <img src='resources/modern/appbar.arrow.up.png'/></a> <a href='" + this.Filename + "?field=" + Field + "&ord=d'> <img src='resources/modern/appbar.arrow.down.png'/> </a> </div>";
	}
	
	public String RenderContactInfo() {
		return "<div id='contact'><img src='resources/modern/appbar.email.hardedge.png'/> supermarket@gmail.com <br /><img src='resources/modern/appbar.phone.png'/> 634 69 69 69</div>";
	}
	
	public String RenderFooter() {
		return "SD & MO<br />2013 - " + String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}
}
