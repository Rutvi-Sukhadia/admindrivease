<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.drivease.model.Admin"%>

<!DOCTYPE html>
<html>
<body>
<% if(session.getAttribute("admin")==null){
	response.sendRedirect("error");}%>
<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar" style="background:#222d32">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="/admindrivease/resources/dist/img/user2-160x160.jpg" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						 <center><label style="color:white;font-size:15px;"><% Admin admin = (Admin)session.getAttribute("admin"); %> 
		                         <% out.println(admin.getFname()); %>  
		                         <% out.print(admin.getLname()); %>
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
				<ul class="sidebar-menu" data-widget="tree">
					<li class="header"><center><h4>MAIN NAVIGATION</h4></center></li>
					
					<li><a href="/admindrivease/admin/home"><i
							class="fa fa-home"></i><span>Home Page</span> <span
							class="pull-right-container">
						</span>
					</a></li>
					<!-- Manage Admin -->
					<li><a href="/admindrivease/admin/adminList"><i
							class="fa fa-users"></i><span>Manage Admins</span> <span
							class="pull-right-container">
						</span>
					</a></li>
					
				<!-- Manage  profile-->
					<li class="active treeview menu-open"><a href="#"> <i
							class="fa fa-user"></i> <span>Manage Profile</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					 <ul class="treeview-menu">
					<li><a href="/admindrivease/admin/editProfile"><i class="fa fa-circle-o"></i>Edit Profile</a></li>
					<li><a href="/admindrivease/admin/changePassword"><i class="fa fa-circle-o"></i>Change Password</a></li>
							
					</ul></li>
					
					
					<!-- Manage Users -->
					<li><a href="/admindrivease/user/userList"> <i class="fa fa-users"></i>
							<span>Manage Users</span> <span class="pull-right-container">
						</span>
					</a></li>
										
					
					<!-- Manage Vehicles -->
					<li><a href="/admindrivease/vehicle/allVehicles"> <i
							class="fa fa-car"></i> <span>Manage Vehicles</span> <span
							class="pull-right-container">
						</span>
					</a></li>
					
					<!-- Manage Drivers -->
					<li><a href="/admindrivease/driver/allDrivers"> <i
							class="fa fa-users"></i> <span>Manage Drivers</span> <span
							class="pull-right-container">
						</span>
					</a></li>
					
					<!-- Manage Filters -->
					<li class="treeview"><a href="#"> <i
							class="fa fa-filter"></i> <span>Manage Filters</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="/admindrivease/vehicleType/typeList"><i
									class="fa fa-circle-o"></i> Manage Vehicle Types</a></li>
							<li><a href="/admindrivease/vehicleCompany/companyList"><i
									class="fa fa-circle-o"></i> Manage Vehicle Companies</a></li>
							<li><a href="/admindrivease/vehicleModel/modelList"><i
									class="fa fa-circle-o"></i> Manage Vehicle Models</a></li>
							<li><a href="/admindrivease/state/statelist"><i
									class="fa fa-circle-o"></i> Manage States</a></li>
							<li><a href="/admindrivease/city/cityList"><i
									class="fa fa-circle-o"></i> Manage Cities</a></li>
							<li><a href="/admindrivease/area/areaList"><i
									class="fa fa-circle-o"></i> Manage Areas</a></li>
						</ul></li>
						
					
					<!-- Manage Payment -->
					
					<!--   View Bookings-->
					<li class="active treeview menu-open"><a href="#"> <i
							class="fa fa-book"></i> <span>View Bookings</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					 <ul class="treeview-menu">
					<li><a href="/admindrivease/booking/allVehicleBookings"><i class="fa fa-circle-o"></i>Vehicle Bookings</a></li>
					<li><a href="/admindrivease/booking/allDriverBookings"><i class="fa fa-circle-o"></i>Driver Bookings</a></li>
							
					</ul></li>
					
					<!-- Manage Feedback -->
					<li><a href="/admindrivease/feedback/feedbackList"> <i
							class="fa fa-edit"></i> <span>Manage Feedbacks</span> <span
							class="pull-right-container">
						</span>
					</a></li>
					
					<!-- Generate Report -->
					
					
					
					<!-- Log Out -->
					<li><a href="/admindrivease/admin/login"> <i
							class="fa fa-power-off"></i> <span>Log Out</span> <span
							class="pull-right-container">
						</span>
					</a></li>
					
					
			</section>
			<!-- /.sidebar -->
		</aside>

</body>
</html>