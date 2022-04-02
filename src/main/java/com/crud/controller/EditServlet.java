package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Student;
import com.crud.service.StudentDAO;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int rollNum = Integer.parseInt(request.getParameter("rollNum"));
		Student student = new StudentDAO().getStudentByRollnum(rollNum);
		
		PrintWriter out = response.getWriter();
		if (student !=null) {
			out.println("<form action = 'UpdateServlet'>");
			out.println("<input type = 'hidden' name = 'txtRollnum' value = '"+ student.getRollnum()+"'>");
			out.println("<input type = 'text' name = 'txtname' value = '"+ student.getStudname()+"'>");
			out.println("<input type = 'date' name = 'txtdob' value = '"+ student.getDOB()+"'>");
			out.println("<input type = 'submit' value= 'Update'>");
			out.println("</form>");
		}
	}

}
