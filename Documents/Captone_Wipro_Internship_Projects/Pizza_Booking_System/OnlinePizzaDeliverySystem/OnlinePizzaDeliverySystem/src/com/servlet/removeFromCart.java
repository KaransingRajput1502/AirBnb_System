package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Cart;

@WebServlet("/removeFromCart")
public class removeFromCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			int id = Integer.parseInt(request.getParameter("id"));
			

			ArrayList<Cart> product = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
			
			for(Cart c : product)
			{
				if(c.getFoodId() == id)
				{
					product.remove(c);
					response.sendRedirect("cart.jsp");
				}
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
