package edu.jsp.User_app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import edu.jsp.User_app.dao.UserDao;
@WebServlet("/signin")
public class ServletSignin extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname =req.getParameter("lname");
		String email =req.getParameter("email");
		String password =req.getParameter("password");
		String phone =req.getParameter("phone");
		
		long p=Long.parseLong(phone);
		
		User u = new User();
		u.setFname(fname);
		u.setLname(lname);
		u.setEmail(email);
		u.setPass(password);
		u.setPhone(p);
		
		UserDao dao= new UserDao();
		
		dao.saveUser(u);
		res.getWriter().print("<h1>Data Inserted</h1>");
		
	}
}
