package com.coursework.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/ecom";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}
	
	
	
	public int addUsers(UserModel studentModel) {
		try(Connection con = getConnection()){
			PreparedStatement st = con.prepareStatement(StringDAO.INSERT_STUDENT);
			
			
			st.setString(1, studentModel.getUserName());
			st.setString(2, studentModel.getFirstName());
			st.setString(3, studentModel.getLastName());
			st.setDate(4, java.sql.Date.valueOf(studentModel.getDob()));
			st.setString(5, studentModel.getGender());
			st.setString(6, studentModel.getEmail());
			st.setString(7, studentModel.getPhoneNumber());
			st.setString(8, studentModel.getSubject());
			st.setString(9, studentModel.getPassword());
			
			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;
			
			
		}catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
			
		}
	}

}
