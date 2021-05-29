<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>DrivEase AdminLTE</title>
  <link rel="shortcut icon" href="/admindrivease/resources/images/drivease_logo/favicon-01.png"">
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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="header.jsp"%>
		<%@ include file="adminsidebar.jsp"%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<br>
			<div class="col-md-12">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 ><center>
								<font size="8">${vehicle.vehicleNumber}</font>
							</center></h3><br>
						<div class="div1" style="float: left; margin-left: 30px;">
							<img
								src="/admindrivease/resources/images/vehiclePicture/${vehicle.vehiclePicture}"
								id="pic1" style="height: 400px; width: 350px;">
						</div>
						<div class="div2" style="float:left;background: white; width:350px; ">
							<p>
								&nbsp;&nbsp;<b>Vehicle Company:</b>&nbsp; ${vehicle.companyName} &nbsp; &nbsp;
								&nbsp; &nbsp; <br>
								<br> &nbsp;&nbsp;<b>Vehicle Model:</b>${vehicle.modelName}<br>
								<br> &nbsp;&nbsp;<b>Vehicle Type:</b>&nbsp; ${vehicle.vehicleTypeName}
								&nbsp; &nbsp; &nbsp; &nbsp; <br>
								<br>&nbsp;&nbsp;<b>Hourly Rent:</b>${vehicle.hourlyRent}<br>
								<br> &nbsp;&nbsp;<b>Daily Rent:</b>${vehicle.dailyRent}<br>
								<br> &nbsp;&nbsp;<b>Description:</b>&nbsp; ${vehicle.description}<br>
								<br> &nbsp;&nbsp;<b>Pick up Address:</b>${vehicle.pickUpAdd}, ${vehicle.areaName}, ${vehicle.cityName}, ${vehicle.stateName}<br>
								<br>
							</p>
						</div>
							<div class="div3" style="float:left; background: white;width:300px;">
								<p>
									&nbsp;&nbsp;<b>Lender Details</b><br>
									<br>&nbsp;&nbsp;<b>Lender Name:</b><a href="/admindrivease/user/viewUser/${vehicle.userId}">${vehicle.lenderName}</a><br>
									<br> &nbsp;&nbsp;<b>Email Address:</b>&nbsp;
									${vehicle.lenderEmail}<br>
									<br> &nbsp;&nbsp;<b>Mobile Number:</b>${vehicle.lenderMobile}<br>
									<br> &nbsp;&nbsp;<b>Driver Provided:</b>${vehicle.checkDriver }<br>
									<c:if test="${vehicle.checkDriver=='Yes'}">
									<br> &nbsp;&nbsp;<b>Driver Details</b><br>
									<br> &nbsp;&nbsp;<b>Driver Name:</b>${vehicle.name}<br>
									<br> &nbsp;&nbsp;<b>Gender:</b>${vehicle.gender}<br>
									<br> &nbsp;&nbsp;<b>Date of birth:</b>${vehicle.dob}<br>
									<br> &nbsp;&nbsp;<b>Mobile Number:</b>${vehicle.mobileNumber}<br>
									</c:if>
									<br>
								</p>
								</div>
								
		
					</div>
					<div class="box-footer box-comments">
										<h3>Reviews</h3>
			<c:forEach var="r" items="${reviewList}">
              <div class="box-comment">
                <!-- User image -->
                <img class="img-circle img-sm" src="/admindrivease/resources/images/userProfilePicture/${r.userProfilePicture}" alt="User Image">

                <div class="comment-text">
                      <span class="username">
                        ${r.userName}
                        <span class="text-muted pull-right">${r.reviewTime}</span>
                      </span><!-- /.username -->
                 ${r.reviewDesc}</div>
                <!-- /.comment-text -->
              </div>
              <!-- /.box-comment -->
              </c:forEach>
                </div>
				</div>
			</div>

			<!-- /.box-header -->
			<!-- Profile Image -->



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
