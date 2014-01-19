package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

public class Stale {
	   private static Stale instance = null;
	   String login ;
	   String pass;
	   Integer accessLevel = 1;
	   String program_title = new String("Supermarket Zbysio!");
	   String login_fail = new String("Nie udało się z jakiegoś powodu zalogować!");
	   String tekst_about = new String("Jakiś klawy tekscik about");
	   String architekci = new String ("Krzysztof Kacprzak, Maciej Nowicki");
	   String viewer = new String("Mateusz Badowski, Szymon Bałdyga");
	   String finance = new String("Jan Węgrowski, Szymon Bartyka");
	   String storage = new String("Daniel Kowalczyk, Damian Zdunek");
	   String human = new String("Witold Rząsa, Bartłomiej Lewiński");
	   String database = new String("Michał Warycha, Mateusz Grajnert");
	   String statistics = new String("Kacper Kleczewski, Krystian Walaszczyk");
	   String webapp = new String("Sylwia Doryń, Michał Owczarczyk");
	   
	   protected Stale() {
		   
	   }
	   public static Stale getInstance() {
	      if(instance == null) {
	         instance = new Stale();
	      }
	      return instance;
	   }
	   
	   
	   
	   public void setLogin(String loginek) {
		   this.login = loginek;
	   }
	   
	   public String getLogin(){
		   return this.login;
	   }
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getProgram_title() {
		return program_title;
	}
	public String getLogin_fail() {
		return login_fail;
	}
	public String getTekst_about() {
		return tekst_about;
	}
	public String getArchitekci() {
		return architekci;
	}
	public String getViewer() {
		return viewer;
	}
	public String getFinance() {
		return finance;
	}
	public String getStorage() {
		return storage;
	}
	public String getHuman() {
		return human;
	}
	public String getDatabase() {
		return database;
	}
	public String getStatistics() {
		return statistics;
	}
	public String getWebapp() {
		return webapp;
	} 
	   
}