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
 * Servlet implementation class MemberBooksServlet
 */
@WebServlet("/MemberBooksServlet")
public class MemberBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberBooksServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("HTML");
		if((request.getParameter("operation")!=null)&&(request.getParameter("operation").equals("Request"))){
			BookServiceController.bookServicecontroller.requestBook(Integer.valueOf(request.getParameter("id")));
		}
		
		ResultSet myGroups=MemberServiceController.memberServicecontroller.getgroups(com.sociallibrary.domain.current_member.id);

		request.setAttribute("name",com.sociallibrary.domain.current_member.firstName+" "+com.sociallibrary.domain.current_member.lastName);
		request.setAttribute("address",com.sociallibrary.domain.current_member.address);
		request.setAttribute("email",com.sociallibrary.domain.current_member.Email);
		request.setAttribute("member", com.sociallibrary.domain.cm.current_member);
		request.setAttribute("groupbooks", BookServiceController.bookServicecontroller.getBooks("GroupBooks",com.sociallibrary.domain.current_member.id));
		request.setAttribute("groups", myGroups);

		getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ResultSet myGroups=MemberServiceController.memberServicecontroller.getgroups(com.sociallibrary.domain.current_member.id);
		String groupName=request.getParameter("groupname").toString();
		ResultSet groupBooks=BookServiceController.bookServicecontroller.getBooksbyGroup(groupName);

		request.setAttribute("groups", myGroups);
		request.setAttribute("groupbooks", groupBooks);
		request.setAttribute("name",com.sociallibrary.domain.current_member.firstName+" "+com.sociallibrary.domain.current_member.lastName);
		request.setAttribute("address",com.sociallibrary.domain.current_member.address);
		request.setAttribute("email",com.sociallibrary.domain.current_member.Email);
		request.setAttribute("member", com.sociallibrary.domain.cm.current_member);

		getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);
	}

}
