package com.sociallibrary.domain;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.MimeMessage;

import com.sociallibrary.Observer;
import com.sociallibrary.db.DatabaseConnection;


public class Member implements Observer {
	private Integer id;
	private String  firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String Email;

	public Member(String firstName,String lastName,String username,String password,String address,String Email){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
		this.setAddress(address);
        this.setEmail(Email);
	}
    
	public void setId(Integer id){
		this.id=id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	private void notifyEmail(String bookname){
		Properties props = new Properties();
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.socketFactory.port", "465");
	   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.port", "465");

	   Session mailSession = Session.getInstance(props, new javax.mail.Authenticator(){
		   protected PasswordAuthentication getPasswordAuthentication(){
			   return new PasswordAuthentication("lalita.vissamsetty@gmail.com", "dattadatta13	");
		   }
	   });

	    try {
	        MimeMessage msg = new MimeMessage(mailSession);
	        msg.setFrom();
	        //Devi - message recipient is hard coded.
	        msg.setRecipients(Message.RecipientType.TO,
	                          "lalita.vissamsetty@gmail.com");
	        //Devi - subject  is hard coded.

	        msg.setSubject("JavaMail hello world example");
	        //msg.setSentDate(new Date());
	       //Devi - sent by whom?

	        msg.setText("Hello, "+bookname+"has been added by ");
	        Transport.send(msg);
	    } catch (MessagingException mex) {
	        System.out.println("send failed, exception: " + mex);
	    }
	}
	
	public void notifyNotification(String bookname){
		try {
			Statement st = DatabaseConnection.databaseInstance.conn.createStatement();
			String sql="Insert into notifications (member_id,notification) values ("+this.id+", '"+bookname+"has been added by "+com.sociallibrary.domain.current_member.firstName+"')";
		    st.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
