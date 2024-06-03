package com.techpalle.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;


@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
      // below code is to verify if data is coming from html page.
	  String e = request.getParameter("tbmail");
	  String p = request.getParameter("tbpw");
	 
	  // As a verification we just print first 
	  PrintWriter pw = response.getWriter();
	  pw.println("<h1> Hi Admin</h1>");
	  pw.println("Email:"+e);
	  pw.println("Password:"+p);
	  // Verification over.
	  
	  
	  // JDBC code to verify whether admin credentials are correct or not
	  boolean result = DataAccess.checkAdminLogin(e,p);
	  
	  if(result == true)
	  {
		 response.sendRedirect("welcome.jsp");
		 pw.println(" : LOGIN SUCCESS");
	  }
	  else
	  {
		  pw.println(" : LOGIN FAIL");
	  }
	}

}
