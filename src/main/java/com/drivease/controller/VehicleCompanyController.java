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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.drivease.model.VehicleCompany;
import com.drivease.service.VehicleCompanyService;


@Controller
@RequestMapping("/vehicleCompany")
@SessionAttributes("admin")
public class VehicleCompanyController {
		
		@Autowired
		VehicleCompanyService companyservice;
		
		@Autowired
		HttpSession session;
		
		@RequestMapping("/companyList")
		public ModelAndView getAllCompanies()
		{
			List<VehicleCompany> list = companyservice.getAll();
			ModelAndView model = new ModelAndView();
			model.setViewName("companyList");
			model.addObject("listcompany",list);
			model.addObject("company",new  VehicleCompany());
			model.addObject("edit",false);
			return model;
		}
		
		@RequestMapping("/saveCompany")
		public String saveCompany(@ModelAttribute("company") VehicleCompany company)
		{
			
			long result1=companyservice.addCompany(company);
			return "redirect:/vehicleCompany/companyList";
		}
		
		/*@RequestMapping("/addCompany")
		public String addCompany(Model model) {
			
			VehicleCompany company=new VehicleCompany();
			model.addAttribute("company", company);
			model.addAttribute("edit",false);
			return "addvehiclecompany";

		}*/
	
		@RequestMapping("/deleteCompany/{id}")
		public String deleteComapny(@PathVariable long id) {
			boolean result=companyservice.deleteCompany(id);
			return "redirect:/vehicleCompany/companyList";
		}

		@RequestMapping("/editCompany/{id}")
		public ModelAndView editCompany(@PathVariable long id ) {
			VehicleCompany company=companyservice.editCompany(id);
			List<VehicleCompany> list = companyservice.getAll();
			ModelAndView model = new ModelAndView();
			model.setViewName("companyList");
			model.addObject("listcompany",list);
			model.addObject("company",company);
			model.addObject("edit",true);
			return model;
		}
}
