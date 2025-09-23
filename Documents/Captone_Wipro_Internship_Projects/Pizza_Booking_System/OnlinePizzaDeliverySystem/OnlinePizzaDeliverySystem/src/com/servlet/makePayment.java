package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.CreditCardDOA;
import com.admin.CreditCardDetails;
import com.admin.foodItemDAO;
import com.user.Cart;

@WebServlet("/makePayment")
public class makePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cardNo = Integer.parseInt(request.getParameter("cardNumber"));
		String cardValFrom = (String) request.getParameter("valFrom");
		String cardValTo = (String) request.getParameter("valTo");
		
		double bal = 20000;
		
		CreditCardDetails cd = new CreditCardDetails();
		
		cd.setBal(bal);
		cd.setCardNo(cardNo);
		cd.setCardValFrom(cardValFrom);
		cd.setCardValTo(cardValTo);
		
		CreditCardDOA cDoa = new CreditCardDOA();
		
		PrintWriter out = response.getWriter();
		
		if(cDoa.addCard(cd))
		{
			ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart_list");
			foodItemDAO fd = new foodItemDAO();
			double sum = fd.getTotalPrice(cart_list);
			cd.setBal(bal-sum);
			cDoa.updateBal(cd);
			out.println("<h1>Payment Successfull</h1>");
		}
	}

}
