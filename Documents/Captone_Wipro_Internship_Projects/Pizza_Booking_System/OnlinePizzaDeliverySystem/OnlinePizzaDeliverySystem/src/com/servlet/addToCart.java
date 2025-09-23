package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.FoodItemDetails;
import com.user.Cart;

@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Cart> cart = new ArrayList<>();
		
		int id =Integer.parseInt(request.getParameter("id"));
		
		Cart cm = new Cart() ;
		
		
		cm.setFoodId(id);
		cm.setQuantity(1);
		
		
		try
		{
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
			
			if(cart_list == null)
			{
				
				cart.add(cm);
				session.setAttribute("cart_list" , cart);
				response.sendRedirect("userHome.jsp");
			}
			else
			{
				cart = cart_list;
				boolean exist = false ;
				
				for(Cart c : cart_list)
				{
					if(c.getFoodId() == id)
					{
						
						exist = true ;
						out.println("<html><h3> item already exist <a href = 'userHome.jsp'> goto home </a> <h3></html>");
					}
					
					
				}
				
				if(!exist)
				{
					cart.add(cm);
					response.sendRedirect("userHome.jsp");
				}
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}


}
