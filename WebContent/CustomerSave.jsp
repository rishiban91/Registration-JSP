<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<script type="text/javascript">
	function validate() {
		if (document.customer.id.value=="") {
			alert("Please enter ID");
			document.customer.id.focus();
			return;
		}
		if (document.customer.name.value=="") {
			alert("Please enter Name");
			document.customer.name.focus();
			return;
		}
		if (document.customer.city.value=="") {
			alert("Please eneter City");
			return;
		}
		if (document.customer.orderid.value=="") {
			alert("Please eneter Order ID");
			return;
		}
		document.customer.method = "post";
		document.customer.action = "save.jsp";
		document.customer.submit();		
	}
	function btnClick() {
	    if (!validData())
	        return false;
	}
</script>
</head>

<body>
	<form name="customer">
		<table>
		<tr>
				<td align="right">Customer ID:</td>
				<td align="left"><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td align="right">Name:</td>
				<td align="left"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align="right">City:</td>
				<td align="left"><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td align="right">Order ID:</td>
				<td align="left"><input type="text" name="orderid"/></td>
			<tr>
				<td align="center"><input type="submit" value="Save"
					onclick="validate()"/></td>
				<td align="center"><input type='submit' value='Cancel' onclick='return btnClick();'></td>
			</tr>
		</table>
	</form>
</body>
</html>