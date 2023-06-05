package com.assg.encora;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assg.encora.mode.StudentResult;
import com.assg.encora.util.DBConnector;

public class InitServlet extends HttpServlet {

	List<StudentResult> studentList = new ArrayList<>();

	// init method loads once when server is started object gets load in memory
	@Override
	public void init() throws ServletException {
		try {
			Connection con = DBConnector.getInstance().getConnection();
			PreparedStatement ps = con.prepareStatement("Select * from emp_db.student_results;");
			ResultSet rs = ps.executeQuery();
			StudentResult sr = null;
			while (rs.next()) {
				sr = new StudentResult();
				sr.setStudentId(rs.getInt(1));
				sr.setStudentName(rs.getString(2));
				sr.setUniversity(rs.getString(3));
				sr.setTotal(rs.getInt(4));
				sr.setResultStatus(rs.getString(5));
				sr.setTotalMarks(rs.getInt(6));
				studentList.add(sr);
			}
			System.out.println("Data lodaded....  " + studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// service method calls for every call
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		pw.print("<html>");
		pw.print("<body bgcolor=\"#35DAEB\">");
		pw.println("<h1> Student " + username  + " Result List: " + new Date() + " </h1>");
		pw.print("<table border=\"2\">");
		pw.print("<tr><td>Student Name</td> <td>University</td> <td>Total</td> <td>Result</td><td>Marks</td> </tr>");
		for (StudentResult studentResult : studentList) {
			pw.print("<tr><td>" + studentResult.getStudentName() + "</td> <td>" + studentResult.getUniversity()
					+ "</td> <td>" + studentResult.getTotal() + "</td> <td>" + studentResult.getResultStatus()
					+ "</td><td>" + studentResult.getTotalMarks() + "</td> </tr>");
		}
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
