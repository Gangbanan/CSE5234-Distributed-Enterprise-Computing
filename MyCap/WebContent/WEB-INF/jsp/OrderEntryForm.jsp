<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href='/MyCap/css/mystyle.css'>
</head>



<body>

<jsp:include page = "head.jsp">
</jsp:include>


<div id="wrapper">
<form:form modelAttribute="totalOrder" method="post" action="purchase/submitItems">

	<table>
		<thead>
			<tr>
				<th>Cap Name</th>
				<th>Price</th> 
				<th>#Left In Stock</th>
				<th>Quantity</th>
			</tr>
		</thead>
		<c:forEach items="${totalOrder.items}" var="item" varStatus="loop">
			<tr>
				<td><c:out value="${item.name}"></c:out></td>
				<td><c:out value="$${item.price}"></c:out></td> 
				<td><c:out value="${item.quantity}"></c:out></td> 
				<td>
				<form:input path="items[${loop.index}].quantity" value="0" />
				<form:input type="hidden" path="items[${loop.index}].name" value="${item.name}" />
				<form:input type="hidden" path="items[${loop.index}].price" value="${item.price}" />
				</td>
			</tr> 
		</c:forEach>
	</table> 
	<input class="confirmation" type="submit" value="Purchase">
</form:form>
</div>

<jsp:include page="footer.jsp">
</jsp:include>
</body>
</html>