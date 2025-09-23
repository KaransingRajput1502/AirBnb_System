package com.admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.servlet.userDetails;

public class userDetailsDAO{
	
	
	
	//Add User
	public static void saveUserInfo(userDetails ud)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
			
			PreparedStatement pst = con.prepareStatement("insert into OnlinePizzaOderingSystem.userdetail values(?,?,?,?,?,?)");
			
			
			
			pst.setString(1, ud.getfName());
			pst.setString(2, ud.getlName());
			pst.setString(3, ud.getEmail());
			pst.setString(4, ud.getcNumber());
			pst.setString(5, ud.getUserNmae());
			pst.setString(6, ud.getPassword());
			

			pst.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
				
	}
	 
	// Get user
	
	public static ResultSet getUser()
	{
		String GET_USER = "Select * from OnlinePizzaOderingSystem.userdetail";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
			
			PreparedStatement pst = con.prepareStatement(GET_USER);
			
			ResultSet rs = pst.executeQuery();
			
			return rs;	
			
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
			return null;
		}
		
	}
	
	


}
