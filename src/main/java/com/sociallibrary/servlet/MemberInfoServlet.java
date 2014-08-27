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
 * Servlet implementation class MemberInfoServlet
 */
@WebServlet("/MemberInfoServlet")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		int id=Integer.valueOf(request.getParameter("id"));
		ResultSet memberBorrowedBooks= BookServiceController.bookServicecontroller.getBooks("BorrowedBooks", id);
		ResultSet memberOwnedBooks=BookServiceController.bookServicecontroller.getBooks("OwnedBooks", id);
		ResultSet memberRequestedBooks=BookServiceController.bookServicecontroller.getBooks("RequestedBooks", id);
		ResultSet memberInfo =MemberServiceController.memberServicecontroller.viewMemberDetails(id);
		
		request.setAttribute("ownedbooks", memberOwnedBooks);
        request.setAttribute("borrowedbooks", memberBorrowedBooks);
        request.setAttribute("requestedbooks", memberRequestedBooks);
        request.setAttribute("memberinfo", memberInfo);
        
        request.setAttribute("name",com.sociallibrary.domain.current_member.firstName+" "+com.sociallibrary.domain.current_member.lastName);
		request.setAttribute("address",com.sociallibrary.domain.current_member.address);
		request.setAttribute("email",com.sociallibrary.domain.current_member.Email);
		request.setAttribute("member", com.sociallibrary.domain.cm.current_member);
	 
		getServletContext().getRequestDispatcher("/member_info.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
