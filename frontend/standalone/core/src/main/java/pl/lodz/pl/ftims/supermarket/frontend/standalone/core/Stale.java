package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

public class Stale {
	   private static Stale instance = null;
	   String login;
	   String pass;
	   Integer accessLevel;
	   
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
	   
	
	   
	   
	   
	}