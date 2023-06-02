package com.assg.encora;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assg.encora.util.DBConnector;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("pass");

		if (validateUser(userName, password)) {
			resp.sendRedirect("/show-result.html");
		} else {
			resp.sendRedirect("/index.html");
		}
	}

	public boolean validateUser(String userName, String password) {

		try {
			Connection con = DBConnector.getInstance().getConnection();
			PreparedStatement ps = con
					.prepareStatement("Select * from emp_db.user_details where username= ? and password= ?;");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
}
