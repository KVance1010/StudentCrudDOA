package com.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.crud.model.Student;

public class StudentDAO {

	private static Connection getConnection() { // creates a method that can be called to created a connection

		Connection con = null; // have to create a connection to the database
		// Step 1 : load Driver in memory
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL = com.mysql.cj.jdbc.Driver // Oracle =

			// This tells where the database is located
			String url = "jdbc:mysql://localhost:3306/cred";
			String username = "root";
			String password = "OZuzz&FA^qkfHKJkU9u=8v4=eS+Jt/8%";

			// Step 2: Database information //DriverManager is used to control jdbc drivers
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public int insertData(Student student) {

		int results = 0;

		try {

			Connection con = getConnection();
			java.sql.Date sdob = new java.sql.Date(student.getDOB().getTime());
			PreparedStatement ps = con
					.prepareStatement("insert into studentDetails(rollno, studname, dob) values(?,?,?)");
			ps.setInt(1, student.getRollnum());
			ps.setString(2, student.getStudname());
			ps.setDate(3, sdob);
			results = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;

	}

	public ArrayList<Student> getRecords() {
		ArrayList<Student> list = new ArrayList<>();

		try {
			Connection con = getConnection(); // calls the method of get connection and returns the current connection
			Statement stmt = con.createStatement(); // Statement allows you read data from the database
			ResultSet rs = stmt.executeQuery("select * from studentdetails"); // ResultSet allows you to save the
																				// information from the database // this
																				// will// get all records

			// add all Records into ArrayList
			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getDate(3)));
			}
			con.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Student getStudentByRollnum(int rollNum) {
		Student student = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM studentdetails WHERE rollno=?");
			ps.setInt(1, rollNum);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt(1), rs.getString(2), rs.getDate(3));
			}
			con.close();
		} catch (Exception e) {
		}
		return student;
	}

	public int UpdateData(Student student) {
		int results = 0;

		try {
			Connection con = getConnection();
			java.sql.Date sdob = new java.sql.Date(student.getDOB().getTime());
			PreparedStatement ps = con.prepareStatement("UPDATE studentdetails SET studname=?, dob=? WHERE rollno=?");
			ps.setInt(3, student.getRollnum());
			ps.setString(1, student.getStudname());
			ps.setDate(2, sdob);

			results = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;

	}

	public int getStudentIdDelete(int rollNum) {
        int results=0;
		try {
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM studentdetails WHERE rollno=?");
			ps.setInt(1, rollNum);
			results = ps.executeUpdate();
			
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

}
