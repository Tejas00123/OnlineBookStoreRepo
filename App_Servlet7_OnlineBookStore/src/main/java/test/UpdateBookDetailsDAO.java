package test;
import java.sql.*;
public class UpdateBookDetailsDAO 
{ int k =0;
  int update(BookBean bb)
  {
	  try
	  {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement
		("Update BookDetails57 set price =? , qty=? where code=? ");
		ps.setDouble(1, bb.getPrice());
		ps.setInt(2, bb.getQty());
		ps.setString(3,bb.getCode());
		
		k = ps.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return k;
  }
}
