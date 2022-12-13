package com.nic.ws.spring.store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmsEmailUtility {
	
	public static boolean send_sms(String connectionUrl, String username,String hashKey, String senderId, String recipent_mob_number , String msg_content){
		
		// Construct data
					
					String user = "username=" + username;
					String hash = "&hash=" + hashKey;
					String message = "&message=" + msg_content;
					String sender = "&sender=" + senderId;
					String numbers = "&numbers=" + recipent_mob_number;
					
					try{
						// Send data
						HttpURLConnection conn = (HttpURLConnection) new URL(connectionUrl).openConnection();
						String data = user + hash + numbers + message + sender;
						conn.setDoOutput(true);
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
						conn.getOutputStream().write(data.getBytes("UTF-8"));
						final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						final StringBuffer stringBuffer = new StringBuffer();
						String line;
						while ((line = rd.readLine()) != null) {
							stringBuffer.append(line);
						}
						rd.close();
						
						System.out.println(stringBuffer.toString());

						
						return true;
					}
					catch(Exception e){
						e.printStackTrace();
						return false;
					}
					
		
	}

	public static boolean send_email(String email_host,String email_port,String sndr_email,String sndr_pwd, InternetAddress[] recipent_address, String msg_subject, String msg_content) throws AddressException, MessagingException{
		
		 String host=email_host;
		 String port=email_port;
		 final String userName=sndr_email; //sender email id
		 final String password=sndr_pwd; //sender email password

		 String subject=msg_subject;
		 
		try{

			// sets SMTP server properties
			Properties properties = new Properties();
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", port);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.ssl.trust", host);
			
			
			
			// creates a new session with an authenticator
			Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, password);
			}
			};
			
			Session session = Session.getInstance(properties, auth);
			
			
			
			// creates a new e-mail message
			Message msg = new MimeMessage(session);
			
			msg.setFrom(new InternetAddress(userName));
			msg.setRecipients(Message.RecipientType.TO, recipent_address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(msg_content, "text/html; charset=utf-8");
			
			// sends the e-mail
			Transport.send(msg);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
}
