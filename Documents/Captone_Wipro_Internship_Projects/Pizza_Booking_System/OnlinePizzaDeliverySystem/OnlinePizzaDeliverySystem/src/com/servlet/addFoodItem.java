package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.admin.FoodItemDetails;
import com.admin.foodItemDAO;

@WebServlet("/addFoodItem")
@MultipartConfig
public class addFoodItem extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String foodName = request.getParameter("foodName");
		int cost = Integer.parseInt(request.getParameter("cost"));
		
		FoodItemDetails food = new FoodItemDetails();
		
		food.setCost(cost);
		food.setFoodName(foodName);
		
		PrintWriter out = response.getWriter();
		
		if(foodItemDAO.addFoodItem(food))
		{
			out.println("<html> <center>");
			out.println("<h2>Fooditem Added Succesfully!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</center></html>");
		}
		else
		{
			out.println("<html>");
			out.println("<h2>OOPS Somthing Worng!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		
	}
	
	public boolean saveImage(InputStream is , String path)
	{
		try
		{
			byte[] byt = new byte[is.available()];
			is.read();
			
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(byt);
			fos.flush();
			fos.close();
			
			return true ;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

}
