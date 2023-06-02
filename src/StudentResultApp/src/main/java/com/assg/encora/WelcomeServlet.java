package com.assg.encora;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter pw = resp.getWriter();
		pw.print("<html>");
		pw.print("<body bgcolor=\"#35DAEB\">");
		pw.println("<h1>Welcome User current time is" + new Date() + " </h1>");
		pw.print("</body>");
		pw.print("</html>");
	}
}
