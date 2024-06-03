package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Student;

// Business logic
public class DataAccess 
{
	public static ArrayList<Student> getStudent() // static methods are utility methods means we can access fast with className
	{
		  ArrayList<Student> al = new ArrayList<Student>(); // intially take empty array list
		try 
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeproject","root","Babu@123");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select*from student");
			if(rs!=null) // if it is not null data is there
			{
				while(rs.next() == true)
				{
					// Read each row from student table
				  int sno = rs.getInt(1);
				  String sname = rs.getString(2);
				  String course = rs.getString(3);
				  String gender = rs.getString(4);
				  String email = rs.getString(5);
				  String qual = rs.getString(6);
					
					// Create student object
				  Student obj = new Student(sno,sname,course,gender,email,qual);
					
					// add student object to arraylist
					al.add(obj);
					//System.out.println("hello...");
				}
			}
			s.close();
			rs.close();
		} 
		catch (ClassNotFoundException | SQLException e) // both are checked exceptions
		{
			e.printStackTrace();
		}

		return al;// we are returning ArrayList here, but there is no statement like that so retun null to resove error at present.
	}
	public static void insertStudent(String sname,String course,String gender,String email,String qual)
	{
		// JDBC code to insert student and check in workbench...
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeproject","root","Babu@123");
		PreparedStatement ps =con.prepareStatement("insert into student(sname,course,gender,email,qual) values(?,?,?,?,?)");
		ps.setString(1,sname);
		ps.setString(2, course);
		ps.setString(3, gender);
		ps.setString(4, email);
		ps.setString(5, qual);
		ps.executeUpdate();
		ps.close();
		con.close();
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
    public static boolean checkAdminLogin(String email,String pw)
    {
    	// JDBC Code read all rows from table
    
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeproject","root","Babu@123");
		    Statement s = con.createStatement();
		  ResultSet res =  s.executeQuery("select * from admin");
		  int count =0;
		  if(res!=null)
		  {
			  while(res.next()==true) // read each row
			  {
				String dbemail =  res.getString(2); // read email
				String dbpw = res.getString(3); // read pw
				if(dbemail.equals(email)&&(dbpw.equals(pw)))
				{
					count++;
					break;
				}
			  }
		  }
		  s.close();
		  con.close();
		  if(count==1)
		  {
			  return true;
		  }
		  else
		  {
			  return false; // admin login failure
		  }

		} 
    	 
    	catch (ClassNotFoundException | SQLException e)
    	 {
			e.printStackTrace();
		}
		return false; // admin login failure  	
    }
}
