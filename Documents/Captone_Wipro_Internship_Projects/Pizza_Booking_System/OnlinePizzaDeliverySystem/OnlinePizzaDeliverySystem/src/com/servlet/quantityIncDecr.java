package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Cart;


@WebServlet("/quantityIncDecr")
public class quantityIncDecr extends HttpServlet {
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<Cart> cart_list =  (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
		
		if(action != null)
		{
			if(action.equals("inc"))
			{
				for(Cart item : cart_list)
				{
					if(item.getFoodId() == id)
					{
						int quantity = item.getQuantity();
						quantity++;
						item.setQuantity(quantity);
						response.sendRedirect("cart.jsp");
					}
				}
			}
		}
		
		if(action != null)
		{
			if(action.equals("dec"))
			{
				for(Cart item : cart_list)
				{
					if(item.getFoodId() == id && item.getQuantity() > 1)
					{
						int quantity = item.getQuantity();
						quantity--;
						item.setQuantity(quantity);
						break;
					}
				}
				
				response.sendRedirect("cart.jsp");
			}
		}
	}

	
}
