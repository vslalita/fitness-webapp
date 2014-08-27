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
 * Servlet implementation class GroupServlet
 */
@WebServlet("/GroupServlet")
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int id=com.sociallibrary.domain.current_member.id;
		ResultSet groupInfo=MemberServiceController.memberServicecontroller.getGroupInformation(id);
		
		request.setAttribute("groupinfo", groupInfo);
		request.setAttribute("name",com.sociallibrary.domain.current_member.firstName+" "+com.sociallibrary.domain.current_member.lastName);
		request.setAttribute("address",com.sociallibrary.domain.current_member.address);
		request.setAttribute("email",com.sociallibrary.domain.current_member.Email);
		request.setAttribute("member", com.sociallibrary.domain.cm.current_member);
		
		getServletContext().getRequestDispatcher("/groups.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
