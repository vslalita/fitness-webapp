package com.sociallibrary.service.operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sociallibrary.db.DBHelper;
import com.sociallibrary.db.DatabaseConnection;
import com.sociallibrary.domain.Book;
import com.sociallibrary.domain.CurrentMember;
import com.sociallibrary.domain.Member;

public class AddOperation implements BookOperationRequest {
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
			Statement st = DatabaseConnection.connectionRequest().createStatement();
			String sql="Select * from groups g, membergroups mg, members m "
					+ "where g.id=mg.group_id "
					+ "and mg.member_id=m.id "
					+ "and mg.member_id="+CurrentMember.getMember().getId();
			ResultSet member=st.executeQuery(sql);
			if(DBHelper.getCount(member)>0){
				member.beforeFirst();
				while(member.next()){
					Member m=new Member(member.getString("firstname"),member.getString("lastname"),member.getString("username"),member.getString("password"),member.getString("address"),member.getString("email"));
					m.setId(member.getInt("id"));
					members.add(m);
				}
			}
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
			st = DatabaseConnection.connectionRequest().createStatement();
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
			members.get(i).notify(book.getBookName());//(book.bookName);
		}
	}

}
