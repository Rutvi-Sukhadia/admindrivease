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

import com.drivease.model.VehicleType;
import com.drivease.service.VehicleTypeService;


@Controller
@RequestMapping("/vehicleType")
@SessionAttributes("admin")
public class VehicleTypeController {
		
		@Autowired
		VehicleTypeService typeservice;
		
		@Autowired
		HttpSession session;
		
		
		@RequestMapping("/typeList")
		public ModelAndView getAlltypes()
		{
			List<VehicleType> list = typeservice.getAll();
			ModelAndView model = new ModelAndView();
			model.setViewName("vehicletypepage");
			model.addObject("typelist",list);
			model.addObject("vehicletype", new VehicleType());
			model.addObject("edit", false);
			return model;
		}
		
		@RequestMapping("/saveType")
		public String saveType(@ModelAttribute("vehicletype") VehicleType vehicletype)
		{
			
			long result1=typeservice.addType(vehicletype);
			return "redirect:/vehicleType/typeList";
		}
	
		@RequestMapping("/deleteType/{id}")
		public String deleteType(@PathVariable long id) {
			boolean result=typeservice.deleteType(id);
			return "redirect:/vehicleType/typeList";
		}

		@RequestMapping("/editType/{id}")
		public ModelAndView editType(@PathVariable long id) {
			List<VehicleType> list = typeservice.getAll();
			ModelAndView model = new ModelAndView();
			VehicleType vehicletype=typeservice.editType(id);
			model.setViewName("vehicletypepage");
			model.addObject("vehicletype", vehicletype);
			model.addObject("typelist", list);
			model.addObject("edit", true);
			return model;
		}
		

}
