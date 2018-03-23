package cl.camiletti.happyFeetWeb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.codec.Charsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Solicitud;

public class Mail {
	public Mail(Environment env) {
		this.env = env;
	}
	private Environment env;
	
	public boolean sendEmailRecover(String to, String nombre, String link, String cc, List<String> archivos) {
		String html = readHtml("RecuperaClave.html");
		html = html.replace("[link]", link);
		return envioSeguro(to, html, 
				"CuidosMisPies - Recuperación de contraseña.", false, true, cc, null);
	}
	
	public boolean sendEmailSolicitudPodologo(String to, String nombre, String link, String cc, List<String> archivos, Solicitud solicitud) {
		String html = readHtml("BienvenidoPodologo.html");
		html = html.replace("[nombre]", nombre);
		return envioSeguro(to, html, 
				"CuidosMisPies - Solicitud realizada.", false, true, cc, null);
	}
	
	public boolean sendEmailSolicitudPaciente(String to, List<String> archivos, Paciente paciente) {
		String html = readHtml("SolicitudPacienteAdmin.html");
		html = html.replace("[nombre]", paciente.getNombres() + " " + paciente.getApellidos());
		html = html.replace("[rut]", paciente.getRut());
		html = html.replace("[direccion]", paciente.getUbicacion().getNombre());
		html = html.replace("[email]", paciente.getEmail());
		html = html.replace("[fono]", paciente.getFono());
		html = html.replace("[comuna]", paciente.getUbicacion().getComuna().getNombre());
		return envioSeguro(to, html, 
				"CuidosMisPies - Solicitud realizada.", false, true, "", archivos);
	}
	
	public boolean sendEmailBienvenidoPaciente(String to, String nombre) {
		String html = readHtml("Bienvenido.html");
		html = html.replace("[nombre]", nombre);
		return envioSeguro(to, html, 
				"CuidosMisPies - Bienvenido a CuidoMisPies.cl", false, true, "", null);
	}
	
	public boolean sendEmailSolicitudPodologoAdmin(String to, String nombre, String link, String cc, List<String> archivos, Solicitud solicitud) {
		String html = readHtml("SolicitudPodologoAdmin.html");
		html = html.replace("[rut]", solicitud.getRutPodologo());
		html = html.replace("[nombre]", solicitud.getNombres() + " " + solicitud.getApellidos() );
		html = html.replace("[direccion]", solicitud.getUbicacion().getNombre());
		html = html.replace("[edad]", new DateUtil().getAge(solicitud.getFechaNacimiento()) + " a&ntilde;os.");
		html = html.replace("[idMinSal]", solicitud.getIdMinSal());
		html = html.replace("[telefono]", solicitud.getFono());
//		html = html.replace("[sexo]", solicitud.getParamSexo().);
		html = html.replace("[email]", solicitud.getEmail());
		return envioSeguro(to, html, 
				"CuidosMisPies - Solicitud de podologo!", false, true, cc, archivos);
	}
	

	private boolean envioSeguro(String to, String htmlBody, String subject, boolean enviarCC, boolean enviarBCC, String cc, List<String> archivos) {
		  String from = env.getProperty("email.from");
		  final String username = env.getProperty("email.user");
		  final String password = env.getProperty("email.pass");
		  //String cc = env.getProperty("email.cc");
		  String bcc = env.getProperty("email.bcc");
		  Properties props = new Properties();
		  props.put("mail.smtp.host", env.getProperty("email.host"));
		  props.put("mail.smtp.port", env.getProperty("email.port"));
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.starttls.enable", env.getProperty("email.tls"));
		
		      Session session = Session.getInstance(props,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(username, password);
		            }
		         });
		
		      try {
		         Message message = new MimeMessage(session);
		         message.setFrom(new InternetAddress(from));
		 
			 if(to.contains(";")){
		 for(String correo : to.split(";")) {
				 message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
			 }
		 } else {
			 message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 }
		    			 
		
		     
		     if(enviarCC) {
		    	 String ccProperty = env.getProperty("email.cc");
		     if(!ccProperty.trim().equals("")) {
		    	 if(ccProperty.contains(";")){
		    		 for(String correo : ccProperty.split(";")) {
		    			 message.addRecipient(Message.RecipientType.CC, new InternetAddress(correo));
		    		 }
		    	 } else {
		    		 message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccProperty));
		    	 }
		    			 
		     }
		 }
		 if(enviarBCC) {
		     if(!bcc.trim().equals("")) {
		    	 if(bcc.contains(";")){
		    		 for(String correo : bcc.split(";")) {
		    			 message.addRecipient(Message.RecipientType.BCC, new InternetAddress(correo));
		    		 }
		    	 } else {
		    		 message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
		    	 }
		    			 
		     }
		 }
		 
		 if(!cc.trim().equals("")) {
			 if(cc.contains(";")){
				 for(String correo : cc.split(";")) {
					 message.addRecipient(Message.RecipientType.CC, new InternetAddress(correo));
				 }
			 } else {
				 message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			 }
		 }
		 message.setSubject(subject);
		 //message.setContent(htmlBody, "text/html; charset=UTF-8");

		 BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setContent(htmlBody, "text/html; charset=UTF-8");
		 Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);
         if(archivos != null)
         for (String archivo : archivos) {
             messageBodyPart = new MimeBodyPart();
             DataSource source = new FileDataSource(FileManagerUtil.ROOT_PATH + File.separator + FileManagerUtil.DIR_SINGLE + File.separator + archivo);
             messageBodyPart.setDataHandler(new DataHandler(source));
             messageBodyPart.setFileName(archivo);
             multipart.addBodyPart(messageBodyPart);
		}


         message.setContent(multipart);

		 
		 
		 Transport.send(message);	  
		 return true;
		 
		  } catch (MessagingException e) {
		     e.printStackTrace();
		     return false;
		  }
	}
	
	
	public String readHtml(String rutaTemplate) {
		StringBuilder stringBuilder = new StringBuilder();
	    try {
    	
	    	InputStream input = getClass().getResourceAsStream("/"+rutaTemplate);
	        BufferedReader br = new BufferedReader(new InputStreamReader(input, Charsets.toCharset("UTF-8")),1024);
	        
	        String line;
	        while ((line = br.readLine()) != null) {
	            stringBuilder.append(line).append('\n');
	        }
	        br.close();
	    } catch (Exception e) {
	        //LOGGER.error(e);
	    }
	    return stringBuilder.toString();
	}
	
}

