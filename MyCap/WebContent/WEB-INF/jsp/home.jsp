<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fashion Caps Here!</title>
<link rel="stylesheet" href='/MyCap/css/mystyle.css'>
</head>
<body>

<jsp:include page = "head.jsp">
</jsp:include>

<div class="about-wrapper">
<h2> Company Vision && Mission </h2>
<p>Provide the latest fa$hion cap.</p>
<h2> Company business strategy </h2>
<p>To be the leader for hats.Represent your team, your town, and your style by customizing your own hat in the Custom Zone. 
Design the hottest brands for young people.</p>


<table>
		<thead>
			<tr>
				<th>Cap</th>
				<th>Cap Name</th>
				<th>Price</th> 
			</tr>
		</thead>
		<c:forEach items="${inventory.items}" var="item" varStatus="loop">
			<tr>
			<td><img class="capimg" src="<c:url value="/images/${item.name}.png"/> " >
			</td> 
			<td> <c:out value="${item.description}" /></td>
			<td> <c:out value="$${item.price}" /> </td>
		</tr>
		</c:forEach>
	</table>
</div>


<jsp:include page="footer.jsp">
</jsp:include>
</body>
</html>