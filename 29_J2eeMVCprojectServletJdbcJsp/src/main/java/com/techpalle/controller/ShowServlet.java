package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Student;


@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 ArrayList<Student> al =  DataAccess.getStudent(); // get Array List data.
		   
		   // After data getting into Array List of servlet we must pass to show.jsp page.
		    request.setAttribute("students", al); // accessed in jsp file with 'getAttribute("students")'
		    RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
		                      rd.forward(request,response);
		  
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
