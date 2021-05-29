package com.drivease.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.service.AdminService;
import com.drivease.service.DriverService;
import com.drivease.service.FeedbackService;
import com.drivease.service.UserService;
import com.drivease.service.VehicleService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class DashboardController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	DriverService driverservice;
	
	@Autowired
	FeedbackService feedbackservice;
	
	@Autowired
	VehicleService vehicleservice;
	

	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/admin/login";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		int users = userservice.getAll().size();
		int vehicles = vehicleservice.getAll().size();
		int drivers = driverservice.getAll().size();
		int admins = adminService.getAll().size();
		int feedbacks = feedbackservice.getAll().size();
		model.addAttribute("users", users);
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("drivers", drivers);
		model.addAttribute("admins", admins);
		model.addAttribute("feedbacks", feedbacks);
		return "adminindex2";
	}

}
