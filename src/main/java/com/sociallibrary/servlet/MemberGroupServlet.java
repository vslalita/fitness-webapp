package com.sociallibrary.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sociallibrary.domain.CurrentMember;
import com.sociallibrary.service.MemberServiceController;

/**
 * Servlet implementation class MemberGroupServlet
 */
@WebServlet("/MemberGroupServlet")
public class MemberGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberGroupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		
//		MemberOperations mo1=new MemberOperations();
//		BookCRUDOperations bo1=new BookCRUDOperations();
//		//ResultSet myBooks=bo1.getMyBooks();
		ResultSet myGroups=MemberServiceController.getInstance().getgroups(CurrentMember.getMember().getId());

		request.setAttribute("name",CurrentMember.getMember().getFirstName()+" "+CurrentMember.getMember().getLastName());
		request.setAttribute("address",CurrentMember.getMember().getAddress());
		request.setAttribute("email",CurrentMember.getMember().getEmail());
		request.setAttribute("member", CurrentMember.getMember());
		request.setAttribute("groups", myGroups);
		getServletContext().getRequestDispatcher("/groups.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
