
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

<jsp:include page = "head.jsp" />

<div class="about-wrapper">
<h1 class="about-title">About Us</h1>
<div class="profiles">
	<div class="profile xin">	
		<img src="/MyCap/images/xin.png" height="210" width="210" alt="Xin Profile">
		<h3>Xin Xu</h3>
		<h4>Job Title: Programmer</h4>
		<h4>Email: xu.3201@osu.edu</h4>
		<p>Xin is a CSE master at the Ohio State University. He loves palying video games.</p>
	</div>
</div>

<div class="profiles">
	<div class="profile allan">	
		<img src="/MyCap/images/allan.png" height="210" width="210" alt="Allan Profile">
		<h3>Allan Sattelberg-Rivera</h3>
		<h4>Job Title: Programmer</h4>
		<h4>Email: Sattelberg-Rivera.1@osu.edu</h4>
		<p>As a 4th year student at Ohio State University enrolled in the university's
Computer Science and Engineering Program, I've completed coursework in both the practical
 and purely mathematical aspects of object oriented programming.  In addition to these conceptual skills,
 I have also worked on full stack webapplication development, relational database design and implementation,
 operating system.</p>
	</div>
</div>

<div class="profiles">
	<div class="profile hongliang">	
		<img src="/MyCap/images/hongliang.jpeg" height="210" width="210" alt="Hongliang Profile">
		<h3>Hongliang Shi</h3>
		<h4>Job Title: CEO</h4>
		<h4>Email: shi.1128@osu.edu</h4>
		<p>I am a graduate student in Computer Science  Engineering Department at The Ohio State University. 
		My current focus is IOS developmen. I am focus on the front end of the web application and also want 
		to participate in backend development</p>
	</div>
</div>

</div>

<jsp:include page="footer.jsp">
</jsp:include>
</body>
</html>