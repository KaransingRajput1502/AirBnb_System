package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.FoodItemDetails;
import com.admin.foodItemDAO;

@WebServlet("/modifyFoodItem")
public class modifyFoodItem extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int foodId = Integer.parseInt(request.getParameter("foodId"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		String foodName = request.getParameter("foodName");
		
		
		FoodItemDetails fd = new FoodItemDetails();
		
		fd.setFoodId(foodId);
		fd.setFoodName(foodName);
		fd.setCost(cost);
		
		PrintWriter out = response.getWriter();
		
		if(foodItemDAO.modifyFoodItem(fd))
		{
			out.println("<html>");
			out.println("<h2>Your Food Details Has Modified Succesfully!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<h2>OOPS Something Worng!!</h2><br>");
			out.println("$ Food Id Dose Not Exist!");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		
		
		
		
	}

}
