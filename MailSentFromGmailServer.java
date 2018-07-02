

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class MailSentFromGmailServer {
	
		   
		 public static void main(String[] args) throws AddressException, MessagingException {
		   boolean status = false;
		   String fromAddress = "from@gmail.com";
		  
		   String pwd = "*****";
		 
		  String toAddress="ilayaraja.narasimman@aaumanalytics.com";
		  Properties properties = System.getProperties();
		   properties.put("mail.smtp.host", "smtp.gmail.com");
		   properties.put("mail.smtp.auth", "true");
		   properties.put("mail.smtp.port", "587");
		   properties.put("mail.smtp.socketFactory.port", "465");
		   properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		   properties.put("mail.smtp.starttls.enable",false);
		   Session session = Session.getInstance(properties,
		       new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication(fromAddress, pwd);
		      }
		       }); 
		      MimeMessage mimeMessage = new MimeMessage(session);    
		     // mimeMessage.setFrom(new InternetAddress(fromAddress));
		      
		      mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));    
		      mimeMessage.setSubject("Hi");
		      mimeMessage.setContent("Welcome", "text/html" );   
		      System.out.println("Waiting To Send Mail");
		      Transport.send(mimeMessage);
		      System.out.println("Mail Sent SuccessFully");
}

}
