package webapp.core;


import java.util.HashMap;

public class wResourceManager {
	
	private String ResourceDirectory = "./resources/";
	public String Stylesheet = "style.css";
	public HashMap <String[], String[]> ImageList = new HashMap<String[], String[]>();
	
	public wResourceManager(String Stylesheet) {
		this.Stylesheet = Stylesheet;	
		
		LoadImages();
	}
	
	public String getStylesheet() {
		return ResourceDirectory + Stylesheet;
	}
	
	public void LoadImages() {
		
	
		
	}
}
