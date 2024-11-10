<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   AdminBean ab = (AdminBean)session.getAttribute("abean");
   BookBean bb = (BookBean)request.getAttribute("bbean");
   out.println("Page belongs to:"+ab.getFname()+"<br>");
  
%>
 <form action = "update" method ="post">
 <input type="hidden" name="bcode" value=<%=bb.getCode() %>> 
 <p>BookPrice:<input type="text" name="bprice" value=<%=bb.getPrice() %>></p>
 <p>BookQty:<input type="text" name="bqty" value=<%=bb.getQty() %>></p>
 <input type="submit" value="UpdateBookDetails">
 </form>
</body>
</html>