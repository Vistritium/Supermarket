package webapp.core;


import java.security.Security;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class wResourceManager {
	
	private String ResourceDirectory = "./resources/";
	public String Stylesheet = "style.css";
	public String CompanyMail = "tomakekjak@gmail.com";
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
	
	
	// ----
	
	 @SuppressWarnings("restriction")
	public void SendMail(String title, String message) throws AddressException, MessagingException {
	        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	        String recipientEmail = this.CompanyMail;
	        String username = "tomakekjak";
	        String password = "teleportacja";
	        // Get a Properties object
	        Properties props = System.getProperties();
	        props.setProperty("mail.smtps.host", "smtp.gmail.com");
	        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	        props.setProperty("mail.smtp.socketFactory.fallback", "false");
	        props.setProperty("mail.smtp.port", "465");
	        props.setProperty("mail.smtp.socketFactory.port", "465");
	        props.setProperty("mail.smtps.auth", "true");

	        /*
	        If set to false, the QUIT command is sent and the connection is immediately closed. If set 
	        to true (the default), causes the transport to wait for the response to the QUIT command.

	        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
	                http://forum.java.sun.com/thread.jspa?threadID=5205249
	                smtpsend.java - demo program from javamail
	        */
	        props.put("mail.smtps.quitwait", "false");

	        Session session = Session.getInstance(props, null);

	        // -- Create a new message --
	        final MimeMessage msg = new MimeMessage(session);

	        // -- Set the FROM and TO fields --
	        msg.setFrom(new InternetAddress(username + "@gmail.com"));
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));
	        
	        String ccEmail = new String();
			if (ccEmail .length() > 0) {
	            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
	        }

	        msg.setSubject(title);
	        msg.setText(message, "UTF-8");
	        msg.setSentDate(new Date());

	        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

	        t.connect("smtp.gmail.com", username, password);
	        t.sendMessage(msg, msg.getAllRecipients());      
	        t.close();
	    }
}
