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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;



import com.drivease.dao.AdminDao;
import com.drivease.model.Admin;
import com.drivease.service.AdminService;
import com.drivease.controller.LoginController;


@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	HttpSession session;
	

	@RequestMapping("/adminList")
	public String adminList(Model model) {
		List<Admin> adminList =adminService.getAll();
		model.addAttribute("listadmin", adminList);
		return "adminlist";
	}
	
	
	@RequestMapping("/addAdmin")
	public String adminRegistrationPage(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin1", admin);
		model.addAttribute("edit", false);
		return "addadmin";
	}
	
	@RequestMapping("/saveAdmin")
	public String saveAdmin(@ModelAttribute("admin1") Admin admin1, BindingResult result, Model model,
			@RequestParam("profilePicture") MultipartFile file1) {
		long result1 = adminService.saveAdmin(admin1, file1);
		if (result1 == 0) {
			model.addAttribute("errorMsg", "It is already exists or something else went wrong..Try again!");
			return "redirect:/admin/addAdmin";
		}
		return "redirect:/admin/adminList";
	}
	

	@RequestMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable long id) {
		boolean result=adminService.deleteAdmin(id);
		return "redirect:/admin/adminList";
	}
	
	@RequestMapping("/editAdmin/{id}")
	public String editAdmin(@PathVariable("id") long id, Model model)
	{
		Admin admin = adminService.getById(id);
		model.addAttribute("admin1", admin);
		model.addAttribute("edit", true);
		return "editadmin";
	}
	@RequestMapping("/updateAdmin")
	public String updateAdmin(@ModelAttribute("admin1") Admin admin1, BindingResult result, Model model,
			@RequestParam("profilePicture") MultipartFile file1)
	{
		long res=adminService.updateAdmin(admin1,file1);
		if (res == 0) {
			model.addAttribute("errorMsg", "Something went wrong..Try again!");
			return "redirect:/admin/editAdmin/"+admin1.getAdminId();
		}
		return "redirect:/admin/adminList";
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String displayLogin(Model model) { 
	    model.addAttribute("login", new LoginController()); 
	    return "adminlogin"; 
	}*/
	
	@RequestMapping("/editProfile")
	public String editProfile(Model model)
	{
		Admin a = (Admin)session.getAttribute("admin");
		Admin admin = adminService.getById(a.getAdminId());
		model.addAttribute("admin1", admin);
		model.addAttribute("edit", true);
		return "editprofile";
	}
	
	@RequestMapping("/updateProfile")
	public String updateProfile(@ModelAttribute("admin1") Admin admin1, BindingResult result, Model model,
			@RequestParam("profilePicture") MultipartFile file1)
	{
		long res=adminService.updateAdmin(admin1,file1);
		if (res == 0) {
			model.addAttribute("errorMsg", "Something went wrong..Try again!");
			return "redirect:/admin/editAdmin/"+admin1.getAdminId();
		}
		return "redirect:/admin/home";
	}
	
	
	
}

