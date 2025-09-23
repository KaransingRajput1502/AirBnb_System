package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.userDetailsDAO;

@WebServlet("/signUp")
public class signUp extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String cNumber = request.getParameter("cNumber");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(fName == "" || lName == "" || email == "" || password == "" || userName == "" || cNumber == "")
		{
			response.sendRedirect("signUp.jsp");
		}
		else
		{
			 userDetails ud = new userDetails();
			 
			 ud.setfName(fName);
			 ud.setlName(lName);
			 ud.setEmail(email);
			 ud.setcNumber(cNumber);
			 ud.setUserName(userName);
			 ud.setPassword(password);
			 
			 
			 userDetailsDAO.saveUserInfo(ud);
			
			
			 response.sendRedirect("logIn.jsp");
			
			
		}
		
		
		
		
		
	}

}
