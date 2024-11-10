package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddBookDetailsServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest req,HttpServletResponse res)
		  throws ServletException, IOException
  {
	  try {
		  HttpSession hs = req.getSession(false);
		  //Accessing existing session
		 if(hs==null)
		 {
			 req.setAttribute("msg", "Session expired");
			 req.getRequestDispatcher("Home.jsp").forward(req, res);;
		 }
		 else
		 {
			 
			 BookBean bb = new BookBean();
			  bb.setCode(req.getParameter("code"));
			  bb.setName(req.getParameter("name"));
			  bb.setAuthor(req.getParameter("author"));
			  bb.setPrice(Double.parseDouble(req.getParameter("price")));
			  bb.setQty(Integer.parseInt(req.getParameter("qty")));
			  
			 int k = new AddBookDetailsDAO().insert(bb);
			 if(k>0)
			 {
				 req.setAttribute("msg", "Book details Added Successfully...");
				 
			 }
			 req.getRequestDispatcher("AddBookDetails.jsp").forward(req, res);
			 
		 }
		
	  }
	  catch(Exception e)
		 {
			 req.setAttribute("msg", "Book details are available");     //here we handle db related exception using try-catch (re-throwing) and here we can use error code also for termination of application flow
			 req.getRequestDispatcher("Error.jsp").forward(req, res);
		 }
  }
}
