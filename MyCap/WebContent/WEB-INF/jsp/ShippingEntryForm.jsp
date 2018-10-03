<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<link rel="stylesheet" href='/MyCap/css/mystyle.css'>
</head>
<body>

<jsp:include page = "head.jsp">
</jsp:include>


<div id="wrapper">
<form:form modelAttribute="shipping" method="post" action="./submitShipping">
	<table>
			<tr>
			    <td>name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
			    <td>addressLine1</td>
				<td><form:input path="addressLine1" /></td>
			</tr>
			<tr>
			    <td>addressLine2</td>	
				<td><form:input path="addressLine2" /></td>
			</tr>
			<tr>
			    <td>city</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
			    <td>state</td>
				<td><form:input path="state" /></td>
			</tr>
			<tr>
			    <td>zip</td>
				<td><form:input path="zip" /></td>
			</tr>
			
		<tr>
			<td colspan="2"><input type="submit" value="Save"></td>
		</tr>
	</table> 
</form:form>

</div>

<jsp:include page="footer.jsp">
</jsp:include>
</body>
</html>