<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "test.AdminBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 AdminBean ab = (AdminBean)session.getAttribute("abean");
 String msg = (String)request.getAttribute("msg");
 out.println("Page belongs to:"+ab.getFname()+"<br>");
 out.println(msg);
%>
<br>
<a href="Book.html">AddBook</a>
<a href="view1">ViewAllBook</a>
<a href="logout">Logout</a>
</body>
</html>