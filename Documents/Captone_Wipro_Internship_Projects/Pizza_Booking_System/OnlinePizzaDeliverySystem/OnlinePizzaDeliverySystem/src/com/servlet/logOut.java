package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logOut")
public class logOut extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Visit Again!!</h1>");
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<a href = logIn.jsp>Log In</a>");
		out.println("</html>");
	}
}
