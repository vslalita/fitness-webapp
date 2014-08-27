package com.sociallibrary.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sociallibrary.GetUserRelatedBooks;
import com.sociallibrary.UpdateBookAvailability;
import com.sociallibrary.UpdateBookBorrower;
import com.sociallibrary.UpdateBookInfo;
import com.sociallibrary.db.DBHelper;
import com.sociallibrary.domain.Book;
import com.sociallibrary.domain.CurrentMember;
import com.sociallibrary.service.factory.GetBooksFactory;
import com.sociallibrary.service.operations.OperationsFacade;

public class BookServiceController {
	//TODO make it private 
	static BookServiceController bookServicecontroller=null;
	private BookServiceController(){
	}

	public void addBook(Book book){
		//TODO - Do we need to create a new instance of facade each time. How about make it a private variable and initialise it once in the constructor.
		OperationsFacade of=new OperationsFacade();
		of.operations("Add", null, book);
		of.executeRequests();
	}

	public void deleteBook(int id){
		OperationsFacade of=new OperationsFacade();
		of.operations("Delete",id,null);
	}

	public void requestBook(int id){
		OperationsFacade of=new OperationsFacade();
		of.operations("Request",id,null);
	}

	public void execute(){
		OperationsFacade of=new OperationsFacade();
		of.executeRequests();
	}

	public ArrayList<String> displayBooks(String bookType){
		OperationsFacade of=new OperationsFacade();
		if(bookType.equals("DeletedBooks")){
			return of.displayDeletedBooks();
		}
		else if(bookType.equals("RequestedBooks")){
			return of.displayRequestedBooks();
		}
		return null;
	}

	public static BookServiceController getInstance(){
		if(bookServicecontroller==null){
			bookServicecontroller=new BookServiceController();
			return bookServicecontroller;
		}
		return bookServicecontroller;
	}

	public ResultSet getBooks(String bookType, int id){
		GetBooksFactory bookFactory=new GetBooksFactory();
		GetUserRelatedBooks books=bookFactory.createBookList(bookType);
		return books.getBooks(id);
	}

	public ResultSet getBookbyId(int memberBookid){
		String sql="Select * "
				+ "from books b,memberbooks mb "
				+ "where mb.book_id=b.id "
				+ "and mb.id="+memberBookid;
		return DBHelper.getQueryResult(sql);
	}

	public void updateBook(String updateField, int id){
		UpdateBookInfo update;
		if(updateField.equals("availability")){
			update=new UpdateBookAvailability();
			update.updateTemplate(id);
		}
		else if(updateField.equals("borrower")){
			update=new UpdateBookBorrower();
			update.updateTemplate(id);
		}
	}

//	public boolean updateAvailibility(int memberBookid){
//		try {
//			Statement st = DatabaseConnection.databaseInstance.conn.createStatement();
//			String sql="Select * from memberbooks where id="+memberBookid;
//			ResultSet bookInfo=st.executeQuery(sql);
//			bookInfo.first();
//			int id=CurrentMember.cm.current_member.id;
//			if(((bookInfo.getInt("owner_id")==id)||(bookInfo.getInt("borrower_id")==id))&&bookInfo.getBoolean("availability")==true){
//				String updateQuery="update memberbooks set availability=false where id="+memberBookid;
//				st.executeUpdate(updateQuery);
//				return true;
//			}
//			else if(((bookInfo.getInt("owner_id")==id)||(bookInfo.getInt("borrower_id")==id))&&bookInfo.getBoolean("availability")==false){
//				String updateQuery="update memberbooks set availability=true where id="+memberBookid;
//				st.executeUpdate(updateQuery);
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}


	public ResultSet getBooksbyGroup(String groupName){
		String sql="Select * "
				+ "from memberbooks mb, groups g, membergroups mg, members m, books b "
				+ "where g.groupname='"+groupName+"' "
				+ "and g.id=mg.group_id "
				+ "and mg.member_id=m.id "
				+ "and mb.owner_id=mg.member_id "
				+ "and b.id=mb.book_id "
				+ "and mb.owner_id !="+com.sociallibrary.domain.current_member.id;
		return DBHelper.getQueryResult(sql);
	}

	//  public String getCategory(int memberBookid){
	//		
	//		try {
	//			Statement st = DatabaseConnection.databaseInstance.conn.createStatement();
	//			String sql="Select * "
	//					+ "from books b, bookcategories bc, memberbooks mb "
	//					+ "where mb.book_id=b.id "
	//					+ "and b.category_id=bc.id "
	//					+ "and mb.id="+memberBookid;
	//		    ResultSet category=st.executeQuery(sql);
	//		    category.first();
	//		    return category.getString("categoryname");
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}

}
