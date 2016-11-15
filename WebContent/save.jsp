<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Details</title>
<%@page import="java.util.*"%>
<%@page import="java.sql.*" %>
<%@page import="com.registration.DbConnection"%>
<%@page import="com.registration.Save"%>
</head>
<body>
<% 	Save obj = new Save();
	int cid = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	int orderid = Integer.parseInt(request.getParameter("orderid"));
	obj.save(cid, name, city, orderid);
%>
</body>
</html>