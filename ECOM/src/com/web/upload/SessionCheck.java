package com.web.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String Name = null; 
			System.out.println("Session checked");
			PrintWriter out = new PrintWriter(response.getWriter());
			HttpSession session = request.getSession(false);
			if(!request.isRequestedSessionIdValid()) {
			 System.out.println("Session is Expired !!");
			}   				
			else  Name = (String) session.getAttribute("user");

			if(session==null) out.println("false"); 
			else {System.out.println("Session's not null "+Name);out.println(Name);}
			out.flush();
			return;

	}

}
