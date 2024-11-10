package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg2")
public class RegisterCustomerServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
  {
	  CustomerBean cb = new CustomerBean();
	  cb.setUname(req.getParameter("uname"));
	  cb.setPword(req.getParameter("pword"));
	  cb.setFname(req.getParameter("fname"));
	  cb.setLname(req.getParameter("lname"));
	  cb.setAddr(req.getParameter("addr"));
	  cb.setMid(req.getParameter("mid"));
	  cb.setPhno(Long.parseLong(req.getParameter("phno")));
	  int k = new RegisterDAO().insert(cb);
	  
	  if(k>0)
	  {
		 
		  req.setAttribute("msg", "Customer registerd Successfully...");
		  req.getRequestDispatcher("Register.jsp").forward(req, res);
	  }
  }
}
