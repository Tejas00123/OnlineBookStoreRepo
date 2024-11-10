package test;
import java.sql.*;
public class AddBookDetailsDAO 
{
 int k=0; 
 int insert(BookBean bb) throws Exception  // in this example we re-throwing the exception
 {                                         //at method call 
	 try
	 {
		Connection con = DBConnection.getCon(); 
		PreparedStatement ps = con.prepareStatement
				("insert into BookDetails57 values (?,?,?,?,?)");
		ps.setString(1, bb.getCode());
		ps.setString(2, bb.getName());
		ps.setString(3, bb.getAuthor());
		ps.setDouble(4,bb.getPrice());
		ps.setInt(5, bb.getQty());
		
		k = ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 throw e; //re-throwing
	 }
	 return k;
 }
}
