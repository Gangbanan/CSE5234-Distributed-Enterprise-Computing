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

<form:form modelAttribute="totalOrder" method="post" action="purchase/submitItems">
	<table>
		<tr>
			<td>Cap Name</td>
			<td>Price</td> 
			<td>Quantity</td>
		</tr>
		<c:forEach items="${totalOrder.items}" var="item" varStatus="loop">
			<tr>
				<td><c:out value="${item.name}"></c:out></td>
				<td><c:out value="$${item.price}"></c:out></td> 
				<td><form:input path="items[${loop.index}].quantity" /></td>
			</tr> 
		</c:forEach>
			<tr>
				<td colspan="2"><input type="submit" value="Purchase"></td>
			</tr>
	</table> 
</form:form>

</body>
</html>