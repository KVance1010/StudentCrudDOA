package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.service.StudentDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int rollNum = Integer.parseInt(request.getParameter("rollNum"));
		int results = new StudentDAO().getStudentIdDelete(rollNum);
		
		if (results > 0) {
			out.println("Record Deleted<br>");
			out.println("<br><a href= 'index.html'>Main page</a>");

		}
	}
	
}
