<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<tr>
		<td><img class="capimg" src="/MyCap/images/cap1.png"></td> 
		<td> New York Yankees '47 MLB Black Series MVP Cap</td>
		<td>$15</td>
	</tr>
	<tr>
		<td><img class="capimg" src="/MyCap/images/cap2.png"></td> 
		<td> Melin The Bar Inlay Cap</td>
		<td>$16</td>
	</tr> 
</table> 

</div>


<jsp:include page="footer.jsp">
</jsp:include>
</body>
</html>