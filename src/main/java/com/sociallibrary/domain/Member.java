package com.sociallibrary.domain;

import java.sql.SQLException;
import java.sql.Statement;

import com.sociallibrary.*;
import com.sociallibrary.db.DatabaseConnection;


public class Member implements IObserver {
	private String  firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String Email;
	int id;

	public Member(String firstName,String lastName,String username,String password,String address,String Email){
		this.firstName=firstName;
		this.lastName=lastName;
		this.username=username;
		this.password=password;
		this.address=address;
        this.Email=Email;

	}
    
	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getEmail(){
		return this.Email;
	}
	
	public void notify(String bookname){
		try {
			Statement st = DatabaseConnection.connectionRequest().createStatement();
			String sql="Insert into notifications (member_id,notification) values ("+this.id+", '"+bookname+"has been added by "+CurrentSession.getMember().firstName+"')";
		    st.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
