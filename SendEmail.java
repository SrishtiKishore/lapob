
package paraballo;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.NamingException;




class Authenticat extends Authenticator
{
		
	@Override
	public PasswordAuthentication getPasswordAuthentication() 
	{
	//  object of PasswordAuthentication using
	// sender email-id and password
	PasswordAuthentication pa = new PasswordAuthentication
			("srishtiydv@gmail.com", "nandkishore");
	
	// return this object
	return pa;
	}
}

public class SendEmail{
    //private Session send_email;
    
    
   

     public boolean sendmail(String email)
     {
       Properties p = System.getProperties();
	
	p.put("mail.smtp.host", "smtp.gmail.com");
	p.put("mail.smtp.port", "587");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	p.put("mail.smtp.auth", "true");
        p.put("mail.debug","true");
        
	Authenticat auth= new Authenticat();
	Session ses = Session.getInstance(p, auth);

        try {

            
         
	MimeMessage mm = new MimeMessage(ses);
		
	// convert string to internet-address
	InternetAddress ia1 = new InternetAddress(email);
	
	mm.setRecipients(Message.RecipientType.TO,email);
	
	mm.setSubject("Verification mail");
	
        

	MimeBodyPart body2 = new MimeBodyPart(); 	
	body2.setContent("<p>Please find report card as HTML file</p>"
			+ "<p>Download the file and open in any web browser</p>", "text/html");

	
	MimeMultipart multipart = new MimeMultipart();
	multipart.addBodyPart(body2); 	
	
	mm.setContent(multipart);
	
	Transport.send(mm);

	System.out.println("Mail has been sent !!");

            
        } 
        catch(Exception e){
           return false;
        }
       return true;
    }

}