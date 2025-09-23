package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreditCardDOA {
	
	static Connection con = null ;
	
	static PreparedStatement pst = null;
	
	public static void getConnection()
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	//add Card
	public static boolean addCard(CreditCardDetails cd)
	{
		String QUERY = "insert into OnlinePizzaOderingSystem.creditcarddetails values(?,?,?,?)";
		
		getConnection();
		
		try{
			pst = con.prepareStatement(QUERY);
			
			pst.setInt(1, cd.getCardNo());
			pst.setString(2, cd.getCardValFrom());
			pst.setString(3, cd.getCardValTo());
			pst.setDouble(4, cd.getBal());
			return true ;
			
			
			
		}catch(Exception e)
		{
			return false ;
		}
	}
	
	//update bal
	
	public static boolean updateBal(CreditCardDetails cd)
	{
		String QUERY = "UPDATE OnlinePizzaOderingSystem.creditcarddetails SET Balance = ? where Credit_Card_Number = ?" ;
		
		getConnection();
		
		try{
			
			pst = con.prepareStatement(QUERY);
			
			pst.setDouble(1, cd.getBal());
			pst.setInt(2, cd.getCardNo());
			
			return true ;
			
			
			
		}catch(Exception e)
		{
			return false ;
		}
	}
}
