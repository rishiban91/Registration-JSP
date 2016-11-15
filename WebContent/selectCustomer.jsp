<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all customers</title>
<%@page import="java.util.*"%>
<%@page import="java.sql.*" %>
<%@page import="com.registration.DbConnection"%>
<%@page import="com.registration.Select"%>
</head>
<body>
</head>
<body>
	<form name="selectAll">
		<table>
			<tr>
                <TH>Customer ID</TH>
                <TH>Name</TH>
                <TH>City</TH>
                <TH>Order ID</TH>
            </tr>
            <%
            	Select sel = new Select();
            	sel.select();
  			%>
		</table>
	</form>
</body>
</html>