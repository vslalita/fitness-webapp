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
			BookServiceController.getInstance().requestBook(Integer.valueOf(request.getParameter("id")));
		}
		
		ResultSet myGroups=MemberServiceController.getInstance().getgroups(CurrentMember.getMember().getId());

		request.setAttribute("name",CurrentMember.getMember().getFirstName()+" "+CurrentMember.getMember().getLastName());
		request.setAttribute("address",CurrentMember.getMember().getAddress());
		request.setAttribute("email",CurrentMember.getMember().getEmail());
		request.setAttribute("member", CurrentMember.getMember());
		request.setAttribute("groupbooks", BookServiceController.getInstance().getBooks("GroupBooks",CurrentMember.getMember().getId()));
		request.setAttribute("groups", myGroups);

		getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ResultSet myGroups=MemberServiceController.getInstance().getgroups(CurrentMember.getMember().getId());
		String groupName=request.getParameter("groupname").toString();
		ResultSet groupBooks=BookServiceController.getInstance().getBooksbyGroup(groupName);

		request.setAttribute("groups", myGroups);
		request.setAttribute("groupbooks", groupBooks);
		request.setAttribute("name",CurrentMember.getMember().getFirstName()+" "+CurrentMember.getMember().getLastName());
		request.setAttribute("address",CurrentMember.getMember().getAddress());
		request.setAttribute("email",CurrentMember.getMember().getEmail());
		request.setAttribute("member", CurrentMember.getMember());

		getServletContext().getRequestDispatcher("/books.jsp").forward(request, response);
	}

}
