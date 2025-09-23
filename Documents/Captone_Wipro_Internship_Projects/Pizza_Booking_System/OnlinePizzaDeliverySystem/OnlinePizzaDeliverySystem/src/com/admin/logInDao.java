package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.userValidation;

public class logInDao {
	
	
	
	public static boolean validate(userValidation uV)
	{
		String query = "Select * From OnlinePizzaOderingSystem.userdetail where Username = ? and Password = ?";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, uV.getUsername());
		pst.setString(2, uV.getPassword());
		
		ResultSet rs = pst.executeQuery();
		
		boolean ifValidate = false;
		if(rs.next())
		{
			ifValidate = true;
		}
		
		return ifValidate;
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return false;
		
	
	}
}
