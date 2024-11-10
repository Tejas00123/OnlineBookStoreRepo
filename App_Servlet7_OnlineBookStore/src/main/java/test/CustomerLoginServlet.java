package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerLog")
public class CustomerLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException 
	{
	   	CustomerBean cb = new CustomerLoginDAO().login
		(req.getParameter("uname"), req.getParameter("pword"));
	   	if(cb==null)
	   	{
	   		req.setAttribute("msg", "Username or password is incorrect please try again...");
	   		req.getRequestDispatcher("Home.jsp").forward(req, res);
	   	}
	   	else
	   	{
	   		HttpSession hs = req.getSession();//creating new session
	   		hs.setAttribute("cbean", cb);
	   		req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
	   	}
	}

}
