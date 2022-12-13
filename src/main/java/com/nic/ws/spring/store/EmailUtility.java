package com.nic.ws.spring.store;

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


public class EmailUtility {
	
	private final static String host = PropStore.KEYS("mail.mail_host");
	private final static String port = PropStore.KEYS("mail.mail_port");
	private final static String userName = PropStore.KEYS("mail.mail_username"); // sender email id
	private final static String password = PropStore.KEYS("mail.mail_password"); // sender email password
	

	private static void mail(String host, String port, final String userName, final String password, String subject,String message, String toAddress) throws AddressException, MessagingException {
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
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };

		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// msg.setText(message);
		msg.setContent(message, "text/html; charset=utf-8");

		// sends the e-mail
		Transport.send(msg);
	}

	public static void sendEmail(String message, String toAddress) throws AddressException, MessagingException {
		String subject = "DEMO";
		mail(host, port, userName, password, subject, message, toAddress);
	}
	
	public static void sendEmail(String subject, String message, String toAddress) throws AddressException, MessagingException {
		mail(host, port, userName, password, subject, message, toAddress);
	}

	public static void sendExceptionMail(String message, String toAddress) throws AddressException, MessagingException {
		String subject = "WS EXCEPTION";
		mail(host, port, userName, password, subject, message, toAddress);
	}

}
