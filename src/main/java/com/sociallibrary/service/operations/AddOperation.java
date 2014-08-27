package com.sociallibrary.service.operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sociallibrary.db.DatabaseConnection;
import com.sociallibrary.db.DBHelper;
import com.sociallibrary.domain.Book;
import com.sociallibrary.domain.CurrentMember;
import com.sociallibrary.domain.Member;
 
public class AddOperation implements BookOperationRequest {
	//TODO Make book private
	Book book;
	private ArrayList<Member> members=new ArrayList<Member>();

	public AddOperation(Book book){
		this.book=book;
	}

	@Override
	public void execute() {
		bo.addBook(book);
		updateRating();
		try {
			//TODO Change this call to be DatabaseConnection.getConnection().createStatement
			Statement st = DatabaseConnection.databaseInstance.conn.createStatement();
			//TODO Change the variable name to be something more meaningful. e.g. groupQuery
			
			//TODO This logic can be done in GroupServiceController right? in GroupServiceController you can have a method :getGroupsByMemberId(memberId). That way you dont have to write logic here

			String sql="Select * from groups g, membergroups mg, members m "
					+ "where g.id=mg.group_id "
					+ "and mg.member_id=m.id "
					+ "and mg.member_id="+com.sociallibrary.domain.current_member.id;
			ResultSet member=st.executeQuery(sql);
			if(DBHelper.getCount(member)>0){
				member.beforeFirst();
				while(member.next()){
					Member m=new Member(member.getString("firstname"),member.getString("lastname"),member.getString("username"),member.getString("password"),member.getString("address"),member.getString("email"));
					m.setId(member.getInt("id"));
					members.add(m);
				}
			}
			//TODO - change to this.notifyAllMembers()
			notifyAllMembers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateRating(){
		String sql= "Select mb.rating memberrating "
				+ "from memberbooks mb,books b "
				+ "where mb.book_id=b.id "
				+ "and b.ISBN="+book.getBookISBN();
		int rating=0;
		int count=0;
		Statement st;
		try {
			st = DatabaseConnection.databaseInstance.conn.createStatement();
			ResultSet ratingList=st.executeQuery(sql);
			while(ratingList.next()){
				count=count+1;
				rating =rating+ratingList.getInt("memberrating");
			}
			String updateRatingQuery="Update books "
					                + "set rating="+(rating/count)+" "
					                + "where isbn="+book.getBookISBN();
			st.executeUpdate(updateRatingQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
  
	public void notifyAllMembers(){
		for(int i=0;i<members.size();i++){
			members.get(i).notifyNotification(book.getBookName());//(book.bookName);
		}
	}

}
