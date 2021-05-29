package com.drivease.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.drivease.model.Area;
import com.drivease.model.City;
import com.drivease.model.State;
import com.drivease.model.User;
import com.drivease.service.AreaService;
import com.drivease.service.CityService;
import com.drivease.service.StateService;
import com.drivease.service.UserService;


@Controller
@SessionAttributes("admin")
@RequestMapping("/user")
public class UserController {
	
		@Autowired
		UserService userservice;
		
		@Autowired
		HttpSession session;
		
		@Autowired
		StateService stateservice;
		
		@Autowired
		CityService cityservice;
		
		@Autowired
		AreaService areaservice;
		
		@RequestMapping("/userList")
		public String listUser(Model model) {
			List<User> userList = userservice.getAll();
			model.addAttribute("listuser", userList);
			return "userlist";
		}
		
		@RequestMapping("/addUser")
		public String adminRegistrationPage(Model model) {
			User user = new User();
			List<State> liststate=stateservice.getAll();
			model.addAttribute("liststate", liststate);
			List<City> listcity=cityservice.getAll();
			model.addAttribute("listcity", listcity);
			List<Area> listarea=areaservice.getAll();
			model.addAttribute("listarea", listarea);
			model.addAttribute("user", user);
			model.addAttribute("edit", false);
			
			return "adduser";
		}
		
		@RequestMapping("/saveUser")
		public String registrationPage(@ModelAttribute("user") User user, BindingResult result, 
				Model model, @RequestParam("profileImage") MultipartFile file1 )
		{
			long result1 = userservice.addUser(user, file1);
			if(result1==0)
			{
				model.addAttribute("error", "Try again!");
				return "redirect:/user/registratationPage";
			}
			return "redirect:/user/userList";
		}
		
		
		@RequestMapping("/deleteUser/{id}")
		public String deleteUser(@PathVariable long id) {
			boolean result=userservice.deleteUser(id);
			return "redirect:/user/userList";
		}
		
		@RequestMapping("/viewUser/{id}")
		public String viewUser(@PathVariable long id,Model model) {
			User user = userservice.getAllDetails(id);
			model.addAttribute("user", user);
			return "userprofile";
		}
		
}
