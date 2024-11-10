package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBookDetailsDAO
{ int k=0;
 int delete(BookBean bb)
 {
	 try
	 {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement
				("Delete from Bookdetails57 where code = ?");
		ps.setString(1, bb.getCode());
		k = ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return k; 
 }
}
