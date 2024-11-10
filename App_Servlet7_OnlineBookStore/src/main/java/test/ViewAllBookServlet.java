package test;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/view1")
public class ViewAllBookServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest req,HttpServletResponse res) 
		  throws ServletException, IOException
  {
	  HttpSession hs = req.getSession(false);
	        //Accessing already created session
	  if(hs==null)
	  {
		  req.setAttribute("msg", "Session expired...");
		  req.getRequestDispatcher("Home.jsp").forward(req, res);
	  }
	  else {
		  ArrayList<BookBean> al = (ArrayList<BookBean>)new ViewAllBooksDAO().retrive();
	      hs.setAttribute("alist", al);
	      req.getRequestDispatcher("ViewAllBooks.jsp").forward(req, res);
	  }
  }
}
