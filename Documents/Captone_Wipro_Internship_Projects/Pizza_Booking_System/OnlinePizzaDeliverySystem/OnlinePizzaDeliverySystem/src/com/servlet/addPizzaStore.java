package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.pizzaStoreDao;
import com.admin.pizzaStoreDetail;

@WebServlet("/addPizzaStore")
public class addPizzaStore extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String storeName = request.getParameter("storeName");
		String storeAdd = request.getParameter("storeAdd");
		String cNumber = request.getParameter("cNumber");
		
		pizzaStoreDetail pizzaStore = new pizzaStoreDetail();
		
		pizzaStore.setcNumber(cNumber);
		pizzaStore.setStoreAdd(storeAdd);
		
		pizzaStore.setStoreName(storeName);
		
		
		PrintWriter out = response.getWriter();
		
		if( pizzaStoreDao.addPizzaStore(pizzaStore))
		{
			out.println("<html>");
			out.println("<h2>Store Added Succesfully!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<h2>OOPS Somthing Worng!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		
	}

}
