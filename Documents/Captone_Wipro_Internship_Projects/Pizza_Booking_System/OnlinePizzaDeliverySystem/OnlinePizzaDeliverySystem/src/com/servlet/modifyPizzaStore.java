package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.modifyPizzaStoreDetails;
import com.admin.pizzaStoreDao;

@WebServlet("/modifyPizzaStore")
public class modifyPizzaStore extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int storeId = Integer.parseInt(request.getParameter("storeId"));
		String storeName = request.getParameter("storeName");
		String storeAdd = request.getParameter("storeAdd");
		String cNumber = request.getParameter("cNumber");
			
		modifyPizzaStoreDetails mps = new modifyPizzaStoreDetails();
		
		mps.setcNumber(cNumber);
		mps.setStoreAdd(storeAdd);
		mps.setStoreId(storeId);
		mps.setStoreName(storeName);
		
		PrintWriter out = response.getWriter();
		
		
		if(pizzaStoreDao.modifyPizzaStore(mps))
		{
			out.println("<html>");
			out.println("<h2>Your Store Details Has Modified Succesfully!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<h2>OOPS Something Worng!!</h2><br>");
			out.println("<a href = adminHome.jsp>Go to home page </a>");
			out.println("</html>");
		}
				
	}

}
