<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "test.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
    out.println("Welcome user : "+cb.getFname()+"<br>");
%>
<a href="view">ViewAllBookDetails</a>
<a href="logout">Logout</a>
</body>
</html>