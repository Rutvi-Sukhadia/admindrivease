<html style="height: auto; min-height: 100%;"><head>
<meta charset="ISO-8859-1">
<title>Vehicle Single Page(Admin Side)</title>
<style>
img
{
height:500px;
width:500px;
}
p
{
font-size:25px;
}


</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="/admindrivease/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="/admindrivease/resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="/admindrivease/resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/admindrivease/resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="/admindrivease/resources/dist/css/skins/_all-skins.min.css">

<!-- Google Font -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body style="background: white; height: auto; min-height: 100%;" class="skin-blue sidebar-mini">





<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="admindrivease/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="admindrivease/resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="admindrivease/resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- jvectormap -->
<link rel="stylesheet" href="admindrivease/resources/bower_components/jvectormap/jquery-jvectormap.css">
<!-- Theme style -->
<link rel="stylesheet" href="admindrivease/resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="admindrivease/resources/dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">


	<div class="wrapper" style="height: auto; min-height: 100%;">

		<header class="main-header">

			<!-- Logo -->
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Admin</b>LTE</span>
			</a>

			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				

			</nav>
		</header>

	





<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar" style="background:#222d32">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="/admindrivease/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						 <center><label style="color:white;font-size:15px;"> 
		                         rutvi
  
		                         sukhadia
		                         </label></center>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<!-- search form -->
				<!-- <form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form> -->
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu tree" data-widget="tree">
					<li class="header"><center><h4>MAIN NAVIGATION</h4></center></li>
					
					<li><a href="/admindrivease/admin/home"><i class="fa fa-car"></i><span>Home Page</span> <span class="pull-right-container">
						</span>
					</a></li>
					<!-- Manage Admin -->
					<li><a href="/admindrivease/admin/addAdmin"><i class="fa fa-car"></i><span>Add Admin</span> <span class="pull-right-container">
						</span>
					</a></li>
					
				<!-- Manage  profile-->
					<li class="active treeview menu-open"><a href="#"> <i class="fa fa-user"></i> <span>Manage Profile</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					 <ul class="treeview-menu">
					<li><a href="editprofile.jsp"><i class="fa fa-circle-o"></i>Edit Profile</a></li>
					<li><a href="changepassword.jsp"><i class="fa fa-circle-o"></i>Change Password</a></li>
							
					</ul></li>
					
					
					<!-- Manage Users -->
					<li class="treeview"><a href="#"> <i class="fa fa-users"></i>
							<span>Manage Users</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="/admindrivease/user/userList"><i class="fa fa-circle-o"></i> All Users </a></li>
							<li><a href="borrowermaster.jsp"><i class="fa fa-circle-o"></i> Borrowers </a></li>
							<li><a href="lendermaster.jsp"><i class="fa fa-circle-o"></i> Lenders </a></li>
							<li><a href="drivermaster.jsp"><i class="fa fa-circle-o"></i> Drivers </a></li>
						</ul>	</li>
					
					
					<!-- Manage Vehicles -->
					<li><a href="vehiclemaster.jsp"> <i class="fa fa-car"></i> <span>Manage Vehicles</span> <span class="pull-right-container">
						</span>
					</a></li>
					
					<!-- Manage Filters -->
					<li class="treeview"><a href="#"> <i class="fa fa-filter"></i> <span>Manage Filters</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="/admindrivease/vehicleCompany/companyList"><i class="fa fa-circle-o"></i> Manage Vehicle Companies</a></li>
							<li><a href="/admindrivease/vehicleModel/modelList"><i class="fa fa-circle-o"></i> Manage Vehicle Models</a></li>
							<li><a href="/admindrivease/state/statelist"><i class="fa fa-circle-o"></i> Manage States</a></li>
							<li><a href="/admindrivease/city/cityList"><i class="fa fa-circle-o"></i> Manage Cities</a></li>
							<li><a href="/admindrivease/area/areaList"><i class="fa fa-circle-o"></i> Manage Areas</a></li>
						</ul></li>
						
					
					<!-- Manage Payment -->
					
					<!-- Manage Feedback -->
					<li><a href="/admindrivease/feedback/feedbackList"> <i class="fa fa-edit"></i> <span>Manage Feedbacks</span> <span class="pull-right-container">
						</span>
					</a></li>
					
					<!-- Generate Report -->
					
					
					
					<!-- Log Out -->
					<li><a href="/admindrivease/admin/login"> <i class="fa fa-power-off"></i> <span>Log Out</span> <span class="pull-right-container">
						</span>
					</a></li>
					
					
			</ul></section>
			<!-- /.sidebar -->
		</aside>



		
<div class="div1" style="float:left;margin-left:50px;"><img src="/admindrivease/resources/images/01.jpg" id="pic1"></div>
<div class="div2" style="height:1400px;float:right;margin-right:510px;background:white">
<center><font size="15">GJ-01-US-3987</font></center>
<p>
&nbsp;&nbsp;<b>Vehicle Id:</b>&nbsp; Saloni Koya &nbsp; &nbsp; &nbsp; &nbsp; <br><br>
&nbsp;&nbsp;<b>Name of Lender:</b>&nbsp; Saloni Koya &nbsp; &nbsp; &nbsp; &nbsp; <br><br>
&nbsp;&nbsp;<b>Email Of Lender:</b>&nbsp; saloni19koya@gmail.com<br><br>
&nbsp;&nbsp;<b>Mobile Number:</b>9725509531<br><br>
&nbsp;&nbsp;<b>Vehicle Number:</b>1234567890<br><br>
&nbsp;&nbsp;<b>Pick up Address:</b>1234567890<br><br>
&nbsp;&nbsp;<b>Hourly Rent:</b>1234567890<br><br>
&nbsp;&nbsp;<b>Daily Rent:</b>1234567890<br><br>
&nbsp;&nbsp;<b>Driver Provided:</b>Yes/No<br><br>
&nbsp;&nbsp;<b>Description:</b>&nbsp; abcdefgh<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Status:</b>Available<br><br>




</p>
<div style="float:left;margin-left:170px;">&nbsp;&nbsp;<center><a href=""><button style="width:240px;height:70px;">REMOVE VEHICLE</button></a></center></div>

</div>
<br><br>

</div>


<!-- jQuery 3 -->
		<script src="/admindrivease/resources/bower_components/jquery/dist/jquery.min.js"></script>
		<!-- Bootstrap 3.3.7 -->
		<script src="/admindrivease/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<!-- FastClick -->
		<script src="/admindrivease/resources/bower_components/fastclick/lib/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script src="/admindrivease/resources/dist/js/adminlte.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="/admindrivease/resources/dist/js/demo.js"></script>
		



<meta charset="ISO-8859-1">
<title>Insert title here</title>


<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.4.18
			</div>
			<strong>Copyright © 2014-2019 <a href="https://adminlte.io">AdminLTE</a>.
			</strong> All rights reserved.
		</footer>



</body></html>