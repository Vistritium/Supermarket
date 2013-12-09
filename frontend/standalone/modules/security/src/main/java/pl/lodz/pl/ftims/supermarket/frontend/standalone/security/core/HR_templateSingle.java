package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

public abstract class HR_templateSingle extends HR_template {
	
	boolean edit;
	
	abstract int commit();
	abstract int edit();
	//abstract int set(UID);
}
