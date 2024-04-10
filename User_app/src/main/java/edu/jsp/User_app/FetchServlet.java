package edu.jsp.User_app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import edu.jsp.User_app.dao.UserDao;
@WebServlet("/fetch")
public class FetchServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	   
		String id=req.getParameter("id");
		int x = Integer.parseInt(id);
		
//	int id= Integer.parseInt(req.getParameter("id"));
		
	UserDao	dao=new UserDao();
	User u = dao.getuserByIdUser(x);
	res.getWriter().print("<html>"
            +"<body>"
			+"<table border=2>"
            +"<tr>"
				+"<th>id</th>"
				+"<th>fname</th>"
				+"<th>lname</th>"
				+"<th>email</th>"
				+"<th>password</th>"
				+"<th>phone</th>"
            +"</tr>"
            +"<tr>"
            	+"<td>"+u.getId()+"</td>"
            	+"<td>"+u.getFname()+"</td>"
            	+"<td>"+u.getLname()+"</td>"
            	+"<td>"+u.getEmail()+"</td>"
            	+"<td>"+u.getPass()+"</td>"
            	+"<td>"+u.getPhone()+"</td>"
            +"</tr>"
            +"</table>"
            +"</body>"
            +"</html>");
		
	}

}
