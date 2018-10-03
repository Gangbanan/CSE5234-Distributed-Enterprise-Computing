<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>payment</title>
	<link rel="stylesheet" href='/MyCap/css/mystyle.css'>
<body>
<jsp:include page = "head.jsp">
</jsp:include>

<div id="wrapper">
<form:form modelAttribute="payment" method="post" action="./submitPayment">
	<table>
			<tr>
				<td>Enter Card Number:</td> <td><form:input path="cardNumber" /></td>
			</tr>
			<tr>
				<td>Enter Expiration Date:</td> <td><form:input path="expirationDate" /></td>
			</tr>
			<tr>
				<td>Enter CVV Code:</td> <td><form:input path="cvvCode" /></td>
			</tr>
			<tr>
				<td>Enter Name on Card:</td> <td><form:input path="cardHolderName" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		<tr>
		</tr>
	</table> 
</form:form>
</div>

<jsp:include page="footer.jsp">
</jsp:include>
</body>
</html>
