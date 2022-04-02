package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Student;
import com.crud.service.StudentDAO;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertData() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			// read values
			int rollnum = Integer.parseInt(request.getParameter("txtRollnum"));
			String name = request.getParameter("txtname");
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtdob"));
			
			// wrap data object
			Student student = new Student (rollnum, name, dob);
			
			StudentDAO sdao = new StudentDAO();
			int results = sdao.insertData(student);
			PrintWriter out = response.getWriter();
			
			if(results > 0) {
				out.println("Record Inserted<br>");
				out.println("<br><a href= 'index.html'>Main page</a>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
