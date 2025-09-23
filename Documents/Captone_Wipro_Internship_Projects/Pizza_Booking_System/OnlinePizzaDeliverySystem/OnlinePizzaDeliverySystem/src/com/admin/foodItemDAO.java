package com.admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.user.Cart;

public class foodItemDAO {
	
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
	//add Food Item
	public static boolean addFoodItem(FoodItemDetails food)
	{
		String ADD_FOOD = "insert into OnlinePizzaOderingSystem.food_item_details(Food_Name , Cost) values(?,?)";
		getConnection();
		try 
		{
			pst = con.prepareStatement(ADD_FOOD);
			
			pst.setString(1, food.getFoodName());
			pst.setInt(2, food.getCost());
			pst.executeUpdate();
			return true ;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	//Modify Food Item
	
	public static boolean modifyFoodItem(FoodItemDetails food)
	{
		getConnection();
		String UPDATE_QUERY = "UPDATE OnlinePizzaOderingSystem.food_item_details SET Food_Name = ? , Cost = ? where Food_Id = ?" ;
		try 
		{
			pst = con.prepareStatement(UPDATE_QUERY);
			pst.setString(1, food.getFoodName());
			pst.setInt(2, food.getCost());
			pst.setInt(3, food.getFoodId());
			pst.executeUpdate();
			return true ;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	// Get Food Items
	
	public static ResultSet getFoodIetms()
	{
		String VIEW_FOOD = "Select * from OnlinePizzaOderingSystem.food_item_details";
		try 
		{
			
			getConnection();
			
			PreparedStatement pst = con.prepareStatement(VIEW_FOOD);
			
			ResultSet rs = pst.executeQuery();
			
			return rs;	
		}
		catch(Exception e)
		{
			e.getStackTrace();
			return null;
		}
	}
	
	//Delete Food Item
	
	public static boolean deleteFoodItem(int foodId)
	{
		String DELETE_FOOD = "Delete from OnlinePizzaOderingSystem.food_item_details where Food_Id = ?";
		try 
		{
			
			getConnection();
			
			PreparedStatement pst = con.prepareStatement(DELETE_FOOD);
			
			pst.setInt(1, foodId);
			
			pst.executeUpdate();
			
			return true;	
		}
		catch(Exception e)
		{
			e.getStackTrace();
			return false;
		}
	}
	
	//Add to Cart
	
	public List<Cart> getCartFoodItem(List<Cart> cartList)
	{
		ArrayList<Cart> foodItem = new ArrayList<>();
		try
		{
			if(cartList.size() > 0)
			{
				for(Cart food : cartList)
				{
					String GET_FOOD = "select * from OnlinePizzaOderingSystem.food_item_details where Food_Id = ?";
					getConnection();
					PreparedStatement pst = con.prepareStatement(GET_FOOD);
					
					pst.setInt(1, food.getFoodId());
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next())
					{
						Cart item = new Cart();
						
						item.setFoodId(rs.getInt(1));
						item.setFoodName(rs.getString(2));
						item.setCost(rs.getInt(3)*food.getQuantity());
						item.setQuantity(food.getQuantity());
						
						foodItem.add(item);						
					}
					
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return foodItem;	
	}
	
	//get total Price
	
	public double getTotalPrice(List<Cart> cartList)
	{
		double sum = 0;
		
		try
		{
			
			if(cartList.size() > 0)
			{
				for(Cart food : cartList)
				{
					String GET_TOTAL_PRICE = "select Cost from OnlinePizzaOderingSystem.food_item_details where Food_Id = ?";
					getConnection();
					PreparedStatement pst = con.prepareStatement(GET_TOTAL_PRICE);
					
					pst.setInt(1, food.getFoodId());
					
					ResultSet rs = pst.executeQuery();
				
					while(rs.next())
					{	
						sum = sum + rs.getInt("Cost") * food.getQuantity();
					}
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return sum;
	}
}
