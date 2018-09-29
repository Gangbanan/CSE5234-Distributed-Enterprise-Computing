<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table, th, td {
		    border: 2px solid black;
		    border-collapse: collapse;
		}
		th, td {
		    padding: 5px;
		    text-align: left;    
		}
	</style>
</head>



<body>
<form:form modelAttribute="order" >
	<table>
		<tr>
			<td>Cap Name</td>
			<td>Price</td> 
			<td>Quantity</td>
		</tr>
		<c:forEach items="${order.items}" var="item" varStatus="loop">
			<tr>
				<td><c:out value="${item.name}"></c:out></td>
				<td><c:out value="$${item.price}"></c:out></td> 
				<td><c:out value="${item.quantity}"></c:out></td>
			</tr>
		</c:forEach>
		
	</table> 
</form:form>

<form:form modelAttribute="shipping">
	<table>
		<tr>
			<td>name</td>
			<td><c:out value="${shipping.name}" ></c:out></td>
		</tr>
		<tr>
		    <td>addressLine1</td>
			<td><c:out value="${shipping.addressLine1}" ></c:out></td>
		</tr>
		<tr>
		    <td>addressLine2</td>	
			<td><c:out value="${shipping.addressLine2}" ></c:out></td>
		</tr>
		<tr>
		    <td>city</td>
			<td><c:out value="${shipping.city}" ></c:out></td>
		</tr>
		<tr>
		    <td>state</td>
			<td><c:out value="${shipping.state}" ></c:out></td>
		</tr>
		<tr>
		    <td>zip</td>
			<td><c:out value="${shipping.zip}" ></c:out></td>
		</tr>
	</table> 
</form:form>

<form:form modelAttribute="payment" method="post" action="./submitPayment">
	<table>
			<tr>
				<td>Enter Card Number:</td> 
				<td>${payment.cardNumber}</td>
			</tr>
			<tr>
				<td>Enter Expiration Date:</td> 
				<td>${payment.expirationDate}</td>
			</tr>
			<tr>
				<td>Enter CVV Code:</td> 
				<td>${payment.cvvCode}</td>
			</tr>
			<tr>
				<td>Enter Name on Card:</td> 
				<td>${payment.cardHolderName}</td>
			</tr>
		<tr>
		</tr>
	</table> 
</form:form>

<form:form method="post" action="./confirmOrder">
	<table>
		<tr>
			<td colspan="2"><input type="submit" value="Confirm"></td>
		</tr>
	</table> 
</form:form>


</body>
</html>