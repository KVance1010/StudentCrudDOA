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


@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int rollnum=	Integer.parseInt(request.getParameter("txtRollnum"));
		//StudentDAO sdao=new StudentDAO();
		/*String ans=sdao.getStudentDOB(rollno);
		PrintWriter out=response.getWriter();
		out.println("student DOB="+ans);*/
		ArrayList<Student> list=new StudentDAO().getStudentView();
		PrintWriter out=response.getWriter();
		out.println("<table border=2>");
		for(Student student:list) {
			out.println("<tr><td>"+student.getRollnum()+"</td><td> "+student.getStudname()+"</td><td> "+student.getDOB()+"</td> ");
}
		
		out.println("</table>");
		
		out.println("<br><a href= 'index.html'>Main page</a>");
		
	}

}
