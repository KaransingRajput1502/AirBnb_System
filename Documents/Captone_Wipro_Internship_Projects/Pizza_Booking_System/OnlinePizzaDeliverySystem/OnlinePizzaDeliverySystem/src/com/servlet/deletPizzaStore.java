package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.pizzaStoreDao;

@WebServlet("/deletPizzaStore")
public class deletPizzaStore extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		
		 
		
		PrintWriter out = response.getWriter();
		
		if(pizzaStoreDao.deleteStore(storeId))
		{
			out.println("<html>");
			out.println("<h2>Pizza Store Deleted Succesfully!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<h2>OOPS Something Worng!!</h2><br>");
			out.println("$ Store Id Not Found!");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		
	}

}
