package edu.jsp.User_app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import edu.jsp.User_app.dao.UserDao;
@WebServlet("/login")
public class LoginServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email =req.getParameter("email");
		String password =req.getParameter("password");
		
		User u= new User();
		u.setEmail(email);
		u.setPass(password);
		
		UserDao dao= new UserDao();
		
		dao.saveUser(u);
		res.getWriter().print("<h1>Data is Inserted</h1>");
		
	}

}
