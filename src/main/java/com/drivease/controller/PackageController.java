package com.drivease.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.drivease.model.PackageList;
import com.drivease.service.PackageService;


@Controller
@RequestMapping("/package")
@SessionAttributes("admin")
public class PackageController {

	@Autowired
	PackageService packageservice;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/packageList")
	public ModelAndView getAllPackage()
	{
		List<PackageList> vehiclepacklist = packageservice.getAllVehiclePackages();
		List<PackageList> driverpacklist = packageservice.getAllDriverPackages();
		ModelAndView model = new ModelAndView();
		model.setViewName("packageList");
		model.addObject("listpackagevehicle",vehiclepacklist);
		model.addObject("listpackagedriver",driverpacklist);
		return model;
	}
	
	@RequestMapping("/savePackage")
	public String savePackage(@ModelAttribute("pack") PackageList pack)
	{
		
		long id=packageservice.addPackage(pack);
		return "redirect:/package/packageList";
	}
	
	@RequestMapping("/addPackage")
	public String addPackage(Model model) {
		
		PackageList pack=new PackageList();
		model.addAttribute("pack", pack);
		model.addAttribute("edit",false);
		return "addpackage";

	}
	@RequestMapping("/deletePackage/{id}")
	public String deletePackage(@PathVariable long id) {
		boolean result=packageservice.deletePackage(id);
		return "redirect:/package/packageList";
	}

	@RequestMapping("/editPackage/{id}")
	public String editPackage(@PathVariable long id,ModelMap model ) {
		PackageList pack=packageservice.editPackage(id);
		model.addAttribute("pack", pack);
		model.addAttribute("edit", true);
		return "addpackage";
	}
	
	
}
