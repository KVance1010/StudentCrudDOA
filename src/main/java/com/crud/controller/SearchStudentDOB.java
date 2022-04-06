package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.service.StudentDAO;

@WebServlet("/SearchStudentDOB")
public class SearchStudentDOB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchStudentDOB() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int rollNum = Integer.parseInt(request.getParameter("txtRollnum"));
		StudentDAO sdao = new StudentDAO();
		String ans = sdao.getStudentDOB(rollNum);
		PrintWriter out = response.getWriter();
		out.print("Student Info: " + ans);
		out.println("<br><a href= 'index.html'>Main page</a>");
	}
}
