package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.foodItemDAO;
import com.admin.pizzaStoreDao;


@WebServlet("/deleteFoodItem")
public class deleteFoodItem extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int foodId = Integer.parseInt(request.getParameter("foodId"));
		
		
		PrintWriter out = response.getWriter();
		
		if(foodItemDAO.deleteFoodItem(foodId))
		{
			out.println("<html>");
			out.println("<h2>Food Item Deleted Succesfully!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<h2>OOPS Something Worng!!</h2><br>");
			out.println("$ Food Id Not Found!");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		
	}

}
