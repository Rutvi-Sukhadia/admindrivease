<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Single Page(Admin Side)</title>
<style>
img
{
height:500px;
width:500px;
}
p
{
font-size:30px;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="/admindrivease/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="/admindrivease/resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="/admindrivease/resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="/admindrivease/resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="/admindrivease/resources/dist/css/skins/_all-skins.min.css">

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body>

<%@ include file="header.jsp"%>
<%@ include file="adminsidebar.jsp"%>
		
<div class="div1" style="float:left;margin-left:50px;"><img src="/admindrivease/resources/images/01.jpg" id="pic1"></div>
<div class="div2" style="height:1800px;width:2000px;background:white">
<center><font size="50">Saloni Koya</font></center>
<p>
&nbsp;&nbsp;<b>Driver Id :</b>&nbsp; 1 &nbsp; &nbsp; &nbsp; &nbsp; <br><br>
&nbsp;&nbsp;<b>Name :</b>&nbsp; Saloni Koya &nbsp; &nbsp; &nbsp; &nbsp; <br><br>
&nbsp;&nbsp;<b>Email :</b>&nbsp; saloni19koya@gmail.com<br><br>
&nbsp;&nbsp;<b>Mobile Number :</b>9725509531<br><br>
&nbsp;&nbsp;<b>Daily Rent:</b>1234567890<br><br>
&nbsp;&nbsp;<b>Hourly Rent:</b>1234567890<br><br>
</p>

<div class="div3" style="margin-left:550px;background:white">
<p>
&nbsp;&nbsp;<b>License Issue Date:</b>1234567890<br><br>
&nbsp;&nbsp;<b>License Expiry Date::</b>1234567890<br><br>
&nbsp;&nbsp;<b>Description:</b>&nbsp; abcdefgh<br><br>
&nbsp;&nbsp;<b>Status:</b>Available<br><br>
&nbsp;&nbsp;<b>License Image &nbsp;</b><img src="/admindrivease/resources/images/01.jpg" id="pic2" style="height:100px;width:180px;" class="div4" style="float:left;margin-left:10px;">
</p>

<br><div style="float:left;margin-left:200px;">&nbsp;&nbsp;<center><a href=""><button style="width:140px;height:70px;">REMOVE DRIVER</button></a></center></div>
<div style="float:left;margin-left:80px;">&nbsp;&nbsp;<center><a href=""><button style="width:140px;height:70px;">SEND EMAIL</button></a></center></div>
</div>





</div>
<br><br>


<!-- jQuery 3 -->
		<script
			src="/admindrivease/resources/bower_components/jquery/dist/jquery.min.js"></script>
		<!-- Bootstrap 3.3.7 -->
		<script
			src="/admindrivease/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<!-- FastClick -->
		<script
			src="/admindrivease/resources/bower_components/fastclick/lib/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script src="/admindrivease/resources/dist/js/adminlte.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="/admindrivease/resources/dist/js/demo.js"></script>
		<%@ include file="adminfooter.jsp"%>
</body>
</html>