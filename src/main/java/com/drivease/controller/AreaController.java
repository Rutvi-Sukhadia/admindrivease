package com.drivease.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.drivease.model.Area;
import com.drivease.model.City;
import com.drivease.model.State;
import com.drivease.service.AreaService;
import com.drivease.service.CityService;
import com.drivease.service.StateService;

@Controller
@RequestMapping("/area")
@SessionAttributes("admin")
public class AreaController {
	
	@Autowired
	AreaService areaservice;
	
	@Autowired
	CityService cityservice;
	
	@Autowired
	StateService stateservice;

	@Autowired
	HttpSession session;
	
	@RequestMapping("/areaList")
	public ModelAndView getAllAreas() {
		List<Area> list = areaservice.getAll();
		ModelAndView model = new ModelAndView();
		Area area = new Area();
		List<State> stateList = stateservice.getAll();
		List<City> cityList = cityservice.getAll();
		model.addObject("stateList", stateList);
		model.addObject("cityList", cityList);
		model.addObject("area", area);
		model.addObject("edit", false);
		model.addObject("listarea", list);
		model.setViewName("arealist");
		return model;
	}


	/*@RequestMapping("/areas")
	public String addAreaPage(Model model) {
		Constituencies constituencies = new Constituencies();
		List<Constituencies> constituenciesList = constituenciesService.getAll();
		List<Regions> regionsList = regionsService.getAll();
		List<Nations> nationsList = nationsService.getAll();
		model.addAttribute("regionList", regionsList);
		model.addAttribute("nationList", nationsList);
		model.addAttribute("constituencyList", constituenciesList);
		model.addAttribute("constituency", constituencies);
		model.addAttribute("edit", false);
		return "constituencies";
	}*/
	
	@RequestMapping("/saveArea")
	public String saveArea(@ModelAttribute("area") Area area) {

		long result1 = areaservice.addArea(area);
		return "redirect:/area/areaList";
	}
	
	@RequestMapping("/deleteArea/{id}")
	public String deleteArea(@PathVariable long id) {
		boolean result = areaservice.deleteArea(id);
		return "redirect:/area/areaList";
	}

	@RequestMapping("/editArea/{id}")
	public ModelAndView editArea(@PathVariable long id) {
		List<Area> list = areaservice.getAll();
		ModelAndView model = new ModelAndView();
		Area area = areaservice.getById(id);
		List<State> stateList = stateservice.getAll();
		List<City> cityList = cityservice.getAll();
		model.addObject("stateList", stateList);
		model.addObject("cityList", cityList);
		model.addObject("area", area);
		model.addObject("edit", true);
		model.addObject("listarea", list);
		model.setViewName("arealist");
		return model;
	}
	
	@RequestMapping(value = "/getCities/{stateId}", method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCitiesByState(@PathVariable("stateId") long stateId) {
	    return cityservice.getAllCitiesByStateId(stateId);
	}
/*
	@RequestMapping("/constituenciesList")
	public String constituenciesList(Model model) {
		List<Constituencies> constituenciesList = constituenciesService.getAll();
		model.addAttribute("constituenciesList", constituenciesList);
		return "constituenciesList";
	}
*/
/*	@RequestMapping(value = { "/addConstituency" }, method = RequestMethod.POST)
	public String saveConstituencies(@ModelAttribute("constituencies") Constituencies constituencies) {
		long result = constituenciesService.saveUpdateConstituencies(constituencies);
		return "redirect:/admin/constituencies";
	}*/

	
}
