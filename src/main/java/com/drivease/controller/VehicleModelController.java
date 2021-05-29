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
import com.drivease.model.VehicleModel;
import com.drivease.model.VehicleType;
import com.drivease.service.VehicleCompanyService;
import com.drivease.service.VehicleModelService;
import com.drivease.service.VehicleTypeService;

@Controller
@RequestMapping("/vehicleModel")
@SessionAttributes("admin")
public class VehicleModelController {

	@Autowired
	VehicleModelService modelservice;

	@Autowired
	VehicleCompanyService companyservice;

	@Autowired
	VehicleTypeService typeservice;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/modelList")
	public ModelAndView getAllCompanies() {
		List<VehicleModel> list = modelservice.getAll();
		ModelAndView model = new ModelAndView();
		VehicleModel vehiclemodel = new VehicleModel();
		List<VehicleCompany> companyList = companyservice.getAll();
		List<VehicleType> typeList = typeservice.getAll();
		model.addObject("typeList", typeList);

		model.addObject("companyList", companyList);
		model.addObject("vehiclemodel", vehiclemodel);
		model.addObject("edit", false);
		model.addObject("listmodel", list);
		model.setViewName("vehiclemodellist");
		return model;
	}

	@RequestMapping("/saveModel")
	public String saveModel(@ModelAttribute("vehiclemodel") VehicleModel vehiclemodel) {

		long result1 = modelservice.addModel(vehiclemodel);
		return "redirect:/vehicleModel/modelList";
	}

	/*@RequestMapping("/addModel")
	public String addModel(Model model) {

		VehicleModel vehiclemodel = new VehicleModel();
		List<VehicleCompany> companyList = companyservice.getAll();
		model.addAttribute("companyList", companyList);
		model.addAttribute("vehiclemodel", vehiclemodel);
		model.addAttribute("edit", false);
		return "addvehiclemodel";

	}*/

	@RequestMapping("/deleteModel/{id}")
	public String deleteModel(@PathVariable long id) {
		boolean result = modelservice.deleteModel(id);
		return "redirect:/vehicleModel/modelList";
	}

	@RequestMapping("/editModel/{id}")
	public ModelAndView editModel(@PathVariable long id) {
		List<VehicleModel> list = modelservice.getAll();
		ModelAndView model = new ModelAndView();
		VehicleModel vehiclemodel = modelservice.editModel(id);
		List<VehicleCompany> companyList = companyservice.getAll();
		List<VehicleType> typeList = typeservice.getAll();
		model.addObject("typeList", typeList);
		model.addObject("companyList", companyList);
		model.addObject("vehiclemodel", vehiclemodel);
		model.addObject("edit", true);
		model.addObject("listmodel", list);
		model.setViewName("vehiclemodellist");
		return model;
	}

}
