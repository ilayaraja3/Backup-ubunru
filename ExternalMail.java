import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ExternalMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		 boolean status = false;
		  
		   String from1="from@aaumanalytics.com";
		   
		  String pwd1 = "****";
		  String host = "mail.aaumanalytics.com";
		  String toAddress="to@aaumanalytics.com";
		  Properties properties = System.getProperties();
		   properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.port", "25");
	    properties.put("mail.debug", "true");
		
		   Session session = Session.getInstance(properties,
		       new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication(from1, pwd1);
		      }
		       }); 
		      MimeMessage mimeMessage = new MimeMessage(session);    
		      mimeMessage.setFrom(new InternetAddress(from1));
		      
		      mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));    
		      mimeMessage.setSubject("hello");
		      mimeMessage.setContent("demo", "text/html" );   
		      System.out.println("Waiting to Send Email");
		      Transport.send(mimeMessage);
		      System.out.println("Message Sent SuccessFully");

	}

}
