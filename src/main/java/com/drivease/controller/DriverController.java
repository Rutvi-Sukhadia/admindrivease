package com.drivease.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.drivease.dao.DriverDao;
import com.drivease.dao.UserDao;
import com.drivease.model.Area;
import com.drivease.model.City;
import com.drivease.model.Driver;
import com.drivease.model.License;
import com.drivease.model.Review;
import com.drivease.model.State;
import com.drivease.model.User;
import com.drivease.model.VehicleType;
import com.drivease.service.AreaService;
import com.drivease.service.CityService;
import com.drivease.service.DriverService;
import com.drivease.service.LicenseService;
import com.drivease.service.ReviewService;
import com.drivease.service.StateService;
import com.drivease.service.UserService;
import com.drivease.service.VehicleTypeService;


@Controller
@RequestMapping("/driver")
@SessionAttributes("admin")
public class DriverController {

	@Autowired
	DriverService driverservice;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	VehicleTypeService typeservice;
	
	@Autowired
	LicenseService licenseservice;
	
	@Autowired
	CityService cityservice;
	
	
	  @Autowired
	  ReviewService reviewService;
	 

	@RequestMapping("/viewDriver/{id}")
	public String viewDriver(@PathVariable long id,Model model) {
		Driver driver = driverservice.getAllDetails(id);
		User user = userservice.getAllDetails(driver.getUserId());
		model.addAttribute("driverUser", user);
		model.addAttribute("driver", driver);
		List<Review> reviewList = reviewService.getReviewsByDriverId(driver.getDriverId());
		model.addAttribute("reviewList", reviewList);
		return "driversinglepage";
	}
	
	@RequestMapping("/allDrivers")
	public ModelAndView getAllDrivers()
	{
		List<Driver> driverlist = driverservice.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("driverlist");
		model.addObject("driverList",driverlist);
		return model;
	}
	
	/*
	 * @RequestMapping("/deactivateAccount") public String deactivateDriver(Model
	 * model) { User user = (User)session.getAttribute("user"); Driver driver1 =
	 * driverservice.getDriverByUserId(user.getUserId()); boolean
	 * result=driverservice.deactivateDriver(driver1.getDriverId()); return
	 * "redirect:/user/home"; }
	 */
	
}
