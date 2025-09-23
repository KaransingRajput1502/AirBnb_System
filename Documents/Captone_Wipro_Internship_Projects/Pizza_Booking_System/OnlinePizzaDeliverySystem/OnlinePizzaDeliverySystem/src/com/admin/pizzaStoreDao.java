package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pizzaStoreDao {
	
	static Connection con = null;
	
	//Add pizza Store
	
	public static boolean addPizzaStore(pizzaStoreDetail pizzaStore)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
			
			PreparedStatement pst = con.prepareStatement("insert into OnlinePizzaOderingSystem.pizza_store_details(Pizza_Store_Name , Address , Contact_no) values(?,?,?)");
			
			
			pst.setString(1,pizzaStore.getStoreName());
			pst.setString(2,pizzaStore.getStoreAdd());
			pst.setString(3,pizzaStore.getcNumber());
			
			pst.executeUpdate();
			
			return true ;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
				
	}
	// modify Pizza Store
	public static boolean modifyPizzaStore(modifyPizzaStoreDetails mps)
	{
		String UPDATE_QUERY = "update OnlinePizzaOderingSystem.pizza_store_details set Pizza_Store_Name = ? , Address = ? , Contact_no = ? where Pizza_Store_Id = ?";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
			
			PreparedStatement pst = con.prepareStatement(UPDATE_QUERY);
			
			pst.setString(1,mps.getStoreName());
			pst.setString(2,mps.getStoreAdd());
			pst.setString(3,mps.getcNumber());
			pst.setInt(4,mps.getStoreId());
			pst.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//View Pizza Stores
	public static ResultSet viewPizzaStore()
	{
		String VIEW_STORE = "Select * from OnlinePizzaOderingSystem.pizza_store_details";
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
			
			PreparedStatement pst = con.prepareStatement(VIEW_STORE);
			
			ResultSet rs = pst.executeQuery();
			
			return rs;	
		}
		catch(Exception e)
		{
			e.getStackTrace();
			return null;
		}
	}
	
	//Delete Store
	
	public static boolean deleteStore(int storeId)
	{
		String DELETE_STORE = "delete from OnlinePizzaOderingSystem.pizza_store_details where Pizza_Store_Id = ? ";
		
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlinePizzaOderingSystem" , "root" , "root");
			
			PreparedStatement pst = con.prepareStatement(DELETE_STORE);
			
			pst.setInt(1, storeId);
			
			pst.executeUpdate();
			
			return true;
			
			 
		}
		catch(Exception e)
		{
			e.getStackTrace();
			return false;
		}
		
	}

}
