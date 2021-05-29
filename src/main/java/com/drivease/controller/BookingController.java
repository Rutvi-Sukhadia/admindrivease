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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.BookingDao;
import com.drivease.dao.VehicleDao;
import com.drivease.model.Booking;
import com.drivease.model.Driver;
import com.drivease.model.User;
import com.drivease.model.Vehicle;
import com.drivease.service.BookingService;
import com.drivease.service.DriverService;
import com.drivease.service.UserService;
import com.drivease.service.VehicleService;

@Controller
@RequestMapping("/booking")
@SessionAttributes("admin")

public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	VehicleService vehicleservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	DriverService driverservice;
	
	@RequestMapping("/allVehicleBookings")
	public String allVehicleBookings(Model model) {
		List<Booking> vehiclelist=bookingService.getAllVehiclesBookings();
		for (Booking booking : vehiclelist) {
			User br = userservice.getById(booking.getUserId());
			booking.setUserName(br.getFname()+" "+br.getLname());
			Vehicle v = vehicleservice.getAllDetails(booking.getVehicleId());
			booking.setVehicleNo(v.getVehicleNumber());
			booking.setVehicleName(v.getCompanyName()+" "+v.getModelName());
		}
		model.addAttribute("vehicleBookingList",vehiclelist);
		return "allvehiclesbookings";
	}
	
	@RequestMapping("/allDriverBookings")
	public String allDriverBookings(Model model) {
		List<Booking> driverlist=bookingService.getAllDriverBookings();
		for (Booking booking : driverlist) {
			User br = userservice.getById(booking.getUserId());
			booking.setUserName(br.getFname()+" "+br.getLname());
			Driver d = driverservice.getById(booking.getDriverId());
			User dr = userservice.getById(d.getUserId());
			booking.setDriverName(dr.getFname()+" "+dr.getLname());
		}
		model.addAttribute("driverBookingList",driverlist);
		return "alldriverbookings";
	}
	
	@RequestMapping("/userBookings/{id}")
	public String myBookinglist(@PathVariable long id,Model model) {
		List<Booking> vehiclelist=bookingService.getMyVehicleBookings(id);
		for (Booking booking : vehiclelist) {
			Vehicle v = vehicleservice.getAllDetails(booking.getVehicleId());
			booking.setVehicleNo(v.getVehicleNumber());
			booking.setVehicleName(v.getCompanyName()+" "+v.getModelName());
		}
		if(vehiclelist.size()>0)
		{
			model.addAttribute("vehicle", "True");
			model.addAttribute("vehicleList",vehiclelist);
		}
		List<Booking> driverlist=bookingService.getMyDriverBookings(id);
		for (Booking booking : driverlist) {
			Driver d = driverservice.getAllDetails(booking.getDriverId());
			booking.setDriverVehicleType(d.getVehicleTypeName());
			User driver = userservice.getAllDetails(d.getUserId());
			booking.setDriverName(driver.getFname()+" "+driver.getLname());
		}
		if(driverlist.size()>0)
		{
			model.addAttribute("driver", "True");
			model.addAttribute("driverList",driverlist);
		}
		User u = userservice.getById(id);
		model.addAttribute("name", u.getFname()+" "+u.getLname());
		return "userbookings";
	}
	
	@RequestMapping("/vehicleBookings/{id}")
	public String myVehicleRequestlist(@PathVariable long id,Model model) {
		List<Booking> vehiclelist=bookingService.getMyVehicleRequests(id);
		for (Booking booking : vehiclelist) {
			User br = userservice.getById(booking.getUserId());
			booking.setUserName(br.getFname()+" "+br.getLname());
		}
		Vehicle v = vehicleservice.getById(id);
		model.addAttribute("name",v.getVehicleNumber());
		model.addAttribute("userBookingList",vehiclelist);
		return "bookingsborrower";
	}
	
	@RequestMapping("/driverBookings/{id}")
	public String myRequestlist(@PathVariable long id,Model model) {
		List<Booking> driverlist=bookingService.getMyDriverRequests(id);
		for (Booking booking : driverlist) {
			User br = userservice.getById(booking.getUserId());
			booking.setUserName(br.getFname()+" "+br.getLname());
		}
		Driver d = driverservice.getById(id);
		User dr = userservice.getById(d.getUserId());
		model.addAttribute("name",dr.getFname()+" "+dr.getLname());
		model.addAttribute("userBookingList",driverlist);
		return "bookingsborrower";
	}
		
}
