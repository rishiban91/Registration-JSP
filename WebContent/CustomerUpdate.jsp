<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
<script type="text/javascript">
	function update() {
		alert("inside update function");
		document.update.method = "post";
		document.update.action = "update.jsp";
		document.update.submit();
	}

</script>

</head>
<body>
	<form name="update">
		<table>
			<tr>
				<td align="right">Customer ID: </td>
				<td align="left"><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td align="right">Name: </td>
				<td align="left"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="Update"
					onclick="update()"/></td>
				
			</tr>
		</table>
	</form>
</body>
</html>