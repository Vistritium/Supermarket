package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

public class Stale {
	   private static Stale instance = null;
	   
	   protected Stale() {
		   
	   }
	   public static Stale getInstance() {
	      if(instance == null) {
	         instance = new Stale();
	      }
	      return instance;
	   }
	   
	   String login;
	   
	   public void setLogin(String loginek) {
		   this.login = loginek;
	   }
	   
	   public String getLogin(){
		   return this.login;
	   }
	   
	   
	}