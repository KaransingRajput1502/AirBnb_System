package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.logInDao;
import com.user.userValidation;

@WebServlet("/payment")
public class payment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = (String) request.getSession().getAttribute("username");
		
		String pass = request.getParameter("password");
		
		userValidation uV = new userValidation();
		
		uV.setUsername(uname);
		uV.setPassword(pass);
		if(logInDao.validate(uV))
		{
			response.sendRedirect("makePayment.jsp");
		}
System.out.println(pass);
	}

}
