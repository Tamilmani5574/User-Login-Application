package edu.jsp.User_app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import edu.jsp.User_app.dao.UserDao;
@WebServlet("/delete")
public class DeleteServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		int i=Integer.parseInt(id);
		
		UserDao	dao=new UserDao();
		  dao.deletUser(i);
		res.getWriter().print("<h1>delete success"+i+"</h1>");
		
	}

}
