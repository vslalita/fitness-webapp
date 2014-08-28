package com.sociallibrary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sociallibrary.db.DatabaseConnection;
import com.sociallibrary.domain.CurrentSession;

public abstract class UpdateBookInfo {
   private ResultSet bookInfo=null;
   private int id;
	
	public void updateTemplate(int memberBookId){
		this.id=memberBookId;
		checkOwnerOrBorrower(memberBookId);
		update();
	}
	
	public ResultSet getBookInfo(){
		return bookInfo;
	}
	public int getId(){
		return id;
	}
	
	public boolean checkOwnerOrBorrower(int memberBookId){
		Statement st;
		try {
			st = DatabaseConnection.connectionRequest().createStatement();
			String sql="Select * from memberbooks where id="+memberBookId;
			ResultSet bookInfo=st.executeQuery(sql);
			bookInfo.first();
			int id=CurrentSession.getMember().getId();
			if(((bookInfo.getInt("owner_id")==id)||(bookInfo.getInt("borrower_id")==id))){
				bookInfo.first();
				this.bookInfo=bookInfo;
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	abstract boolean update();
}
