package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Student;
import com.crud.service.StudentDAO;

@WebServlet("/ViewRecords")
public class ViewRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			ArrayList<Student> list = new StudentDAO().getRecords();
			
			out.println("<table border= 5>");
			for (Student student : list) {

				out.println("<tr><td>" + student.getRollnum() + "</td><td> " + student.getStudname()
				+ "</td><td> " + student.getDOB() + "</td> ");
				
				out.println("<td><a href= 'EditServlet?rollNum="+ student.getRollnum() + "'>Edit</a></td>");
				out.println("<td><a href= 'DeleteServlet?rollNum="+ student.getRollnum() + "'>Delete </a></td></tr>");
			}
			
			
		    out.println("</table><br><br>");
		    out.println("<br><a href= 'index.html'>Main page</a>");
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
