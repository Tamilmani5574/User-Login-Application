package edu.jsp.User_app;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import edu.jsp.User_app.dao.UserDao;
@WebServlet("/getall")
public class GetAllServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		UserDao dao=new UserDao();
		List<User>u=dao.getAll();
		req.setAttribute("list", u);
		req.getRequestDispatcher("getAll").forward(req, res);
		
		String html ="<html>"
				+"<table border=2>"
	            +"<tr>"
					+"<th>id</th>"
					+"<th>fname</th>"
					+"<th>lname</th>"
					+"<th>email</th>"
					+"<th>password</th>"
					+"<th>phone</th>"
	            +"</tr>";
		 for(User u1:u) {
			 
			 html=html
					 +"<tr>"
		            	+"<td>"+u1.getId()+"</td>"
		            	+"<td>"+u1.getFname()+"</td>"
		            	+"<td>"+u1.getLname()+"</td>"
		            	+"<td>"+u1.getEmail()+"</td>"
		            	+"<td>"+u1.getPass()+"</td>"
		            	+"<td>"+u1.getPhone()+"</td>"
		            +"</tr>";
		 }
		 
		 html=html
				 +"</table>"
			     +"</html>";
			 res.getWriter().print(html);
		 
	}

}
