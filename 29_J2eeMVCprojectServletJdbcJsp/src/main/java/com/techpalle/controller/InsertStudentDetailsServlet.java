package com.techpalle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Student;


@WebServlet("/insertstudent")
public class InsertStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InsertStudentDetailsServlet() 
    {
        super(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	  
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		String sname = request.getParameter("sname");
		String course = request.getParameter("course");
		String gender = request.getParameter("rdGender");
		String email = request.getParameter("tbEmail");
		String qual = request.getParameter("chkqual");
		
		// As a verification print above data
//        PrintWriter pw = response.getWriter(); if it is working put in comment line from next updation code, because not necessary
//        pw.println("Student name is :"+sname);
//        pw.println("Course name is :"+course);
		
		DataAccess.insertStudent(sname, course , gender, email, qual);
        
	}

}
