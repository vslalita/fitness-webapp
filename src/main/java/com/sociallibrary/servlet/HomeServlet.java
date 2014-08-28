package com.sociallibrary.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sociallibrary.domain.CurrentMember;
import com.sociallibrary.service.BookServiceController;
import com.sociallibrary.service.MemberServiceController;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setAttribute("name", CurrentMember.cm.current_member.firstName+" "+CurrentMember.cm.current_member.lastName);
		if(request.getParameter("operation")!=null&&request.getParameter("operation").equals("Delete")){
			BookServiceController.getInstance().deleteBook(Integer.valueOf(request.getParameter("id")));
		}
		
		int id=CurrentMember.getMember().getId();
		ResultSet myBooks=BookServiceController.getInstance().getBooks("OwnedBooks",id);
		ResultSet myBorrowedBooks=BookServiceController.getInstance().getBooks("BorrowedBooks",id);
		ResultSet myRequestedBooks=BookServiceController.getInstance().getBooks("RequestedBooks",id);
		ResultSet myGroups=MemberServiceController.getInstance().getgroups(CurrentMember.getMember().getId());
		
		
		request.setAttribute("name",CurrentMember.getMember().getFirstName()+" "+CurrentMember.getMember().getLastName());
		request.setAttribute("address",CurrentMember.getMember().getAddress());
		request.setAttribute("email",CurrentMember.getMember().getEmail());
		request.setAttribute("member", CurrentMember.getMember());
        request.setAttribute("ownedbooks", myBooks);
        request.setAttribute("groups", myGroups);
		request.setAttribute("borrowedbooks", myBorrowedBooks);
		request.setAttribute("requestedbooks", myRequestedBooks);
        
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
