package com.exerciseplanner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class Client extends HttpServlet {
	private static final long serialVersionUID = 7L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FitnessPlanBuilder planBuilder;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	
		if((request.getParameterValues("services")==null)||(request.getParameterValues("services").length<2)){
			out.print("<link href='css/bootstrap.min.css' rel='stylesheet'><link href='css/custom.css' rel='stylesheet'><script src='http://code.jquery.com/jquery-latest.min.js'></script><script src='js/bootstrap.min.js'></script><div class='container jumbotron page-header' style='background-color: #5bc0de;'><h2><large> BoFit Inc.</large></h2></div>");
			out.print("<div class='container'");
			out.print("<h2> You must select atleast two services</h2>");
			return;
		}
		
		FitnessPlanFacade planDocGen=new FitnessPlanFacade(request.getParameterValues("services"),request.getParameter("plan"),request.getParameter("doc"));
		out.print(planDocGen.constructSystem(request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),request.getParameter("age")));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
