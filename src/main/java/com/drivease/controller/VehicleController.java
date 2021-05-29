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

import com.drivease.dao.VehicleDao;
import com.drivease.dao.UserDao;
import com.drivease.model.Area;
import com.drivease.model.City;
import com.drivease.model.LenderDriver;
import com.drivease.model.Review;
import com.drivease.model.Vehicle;
import com.drivease.model.VehicleCompany;
import com.drivease.model.VehicleModel;
import com.drivease.model.State;
import com.drivease.model.User;
import com.drivease.model.VehicleType;
import com.drivease.service.AreaService;
import com.drivease.service.CityService;
import com.drivease.service.LenderDriverService;
import com.drivease.service.ReviewService;
import com.drivease.service.VehicleService;
import com.drivease.service.StateService;
import com.drivease.service.UserService;
import com.drivease.service.VehicleCompanyService;
import com.drivease.service.VehicleModelService;
import com.drivease.service.VehicleTypeService;
import com.drivease.serviceimpl.VehicleCompanyServiceImpl;



@Controller
@RequestMapping("/vehicle")
@SessionAttributes("admin")
public class VehicleController {

	@Autowired
	VehicleService vehicleservice;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LenderDriverService lenderdriverservice;
	
	@Autowired
	VehicleCompanyService companyservice;
	
	@Autowired
	VehicleModelService modelservice;
	
	@Autowired
	StateService stateservice;
	
	@Autowired
	CityService cityservice;
	
	@Autowired
	AreaService areaservice;
	
	@Autowired
	VehicleTypeService typeservice;
	
	
	  @Autowired 
	  ReviewService reviewService;
	 	
	@RequestMapping("/allVehicles")
	public ModelAndView getAllVehicles()
	{
		List<Vehicle> vehiclelist = vehicleservice.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("vehiclelist");
		model.addObject("vehicleList",vehiclelist);
		return model;
	}
	/*@RequestMapping("/deleteVehicle/{id}")
	public String deleteVehicle(@PathVariable long id) {
		boolean result=vehicleservice.deleteVehicle(id);
		return "redirect:/vehicle/manageMyVehicles";
		
	}*/
	
	@RequestMapping("/viewVehicle/{id}")
	public String viewVehicle(@PathVariable long id,Model model) {
		Vehicle vehicle = vehicleservice.getAllDetails(id);
		if(vehicle.getWithDriver()==1)
		{
			LenderDriver ld =lenderdriverservice.getByVehicleId(vehicle.getVehicleId());
			vehicle.setName(ld.getName());
			vehicle.setGender(ld.getGender());
			vehicle.setDob(ld.getDob());
			vehicle.setMobileNumber(ld.getMobileNumber());
			vehicle.setCheckDriver("Yes");
			model.addAttribute("driverPresent",true);
		}
		else {
			vehicle.setCheckDriver("No");
			
		}
		model.addAttribute("vehicle", vehicle);
		List<Review> reviewList = reviewService.getReviewsByVehicleId(vehicle.getVehicleId());
		model.addAttribute("reviewList", reviewList);
		return "vehiclesinglepage";
	}
	
}

