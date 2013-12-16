package webapp.core;


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
		
		return "<div class='sortbuttons'><a href='" + this.Filename + "?field=" + Field + "&ord=a'> gora </a> <a href='" + this.Filename + "?field=" + Field + "&ord=d'> dol </a> </div>";
	}
	
}
