package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.admin.logInDao;
import com.user.userValidation;

@WebServlet("/logIn")

public class logIn extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		userValidation uV = new userValidation();
		
		uV.setUsername(uname);
		uV.setPassword(pass);
		
		PrintWriter out = response.getWriter();
		
		
		if(uname.equals("admin") && pass.equals("admin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("adminHome.jsp");
		}
		else if(logInDao.validate(uV))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("userHome.jsp");
		}
		else
		{
			out.println("Log In Unsuccesful!!");
			response.sendRedirect("logIn.jsp");
		}
		
		
	}

}
