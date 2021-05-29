package com.drivease.serviceimpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.BookingDao;
import com.drivease.dao.DriverDao;
import com.drivease.dao.VehicleDao;
import com.drivease.dao.UserDao;
import com.drivease.model.BookDriver;
import com.drivease.model.BookVehicle;
import com.drivease.model.Booking;
import com.drivease.model.Driver;
import com.drivease.model.Vehicle;
import com.drivease.model.User;
import com.drivease.service.BookingService;
import com.drivease.util.DateTimeOperation;
import com.drivease.util.Mailer;

@Service("bookingservice")
@Transactional
@SessionAttributes("admin")

public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingDao bookingDao;

	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	DriverDao driverdao;
	
	public List<Booking> getAllVehiclesBookings() {
		return bookingDao.getAllVehicleBookings();
	}

	public List<Booking> getAllDriverBookings() {
		return bookingDao.getAllDriverBookings();
	}

	public List<Booking> getMyVehicleBookings(long id) {
		List<Booking> list = bookingDao.getMyVehicleBookings(id);
		return list;
	}
	
	public List<Booking> getMyDriverBookings(long id) {
		List<Booking> list = bookingDao.getMyDriverBookings(id);
		return list;
	}


	public List<Booking> getMyVehicleRequests(long id) {
		List<Booking> list = bookingDao.getMyVehicleRequests(id);
		return list;
	}
	
	public List<Booking> getMyDriverRequests(long id) {
		List<Booking> list = bookingDao.getMyDriverRequests(id);
		return list;
	}

	public int checkVehicleBooking(Booking booking, long id) {
		booking.setStartingDate(DateTimeOperation.changeStrToDate(booking.getStartDate()));
		booking.setEndingDate(DateTimeOperation.changeStrToDate(booking.getEndDate()));
		return bookingDao.checkVehicleBooking(booking,id);
	}

	public int checkDriverBooking(Booking booking, long id) {
		booking.setStartingDate(DateTimeOperation.changeStrToDate(booking.getStartDate()));
		booking.setEndingDate(DateTimeOperation.changeStrToDate(booking.getEndDate()));
		return bookingDao.checkDriverBooking(booking,id);
	}

	public int isVehicleBooked(long id) {
		return bookingDao.isVehicleBooked(id);
	}

}




