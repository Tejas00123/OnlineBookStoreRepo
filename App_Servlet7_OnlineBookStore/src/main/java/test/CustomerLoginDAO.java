package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO 
{
 CustomerBean cb = null;
 public CustomerBean login(String uName,String pWord)
 {
	 try
	 {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement
				("Select * from Customer57 where uname = ? and pword = ?");
		ps.setString(1,uName);
		ps.setString(2, pWord);
		
	  ResultSet rs = ps.executeQuery();
	  if(rs.next())
	  {
		  cb = new CustomerBean();
		  cb.setUname(rs.getString(1));
		  cb.setPword(rs.getString(2));
		  cb.setFname(rs.getString(3));
		  cb.setLname(rs.getString(4));
		  cb.setAddr(rs.getString(5));
		  cb.setMid(rs.getString(6));
		  cb.setPhno(rs.getLong(7));
	  }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return cb;
 }
}
