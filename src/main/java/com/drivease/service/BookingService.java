package com.drivease.service;

import java.util.List;

import com.drivease.model.Booking;

public interface BookingService {

	List<Booking> getMyVehicleBookings(long id);

	List<Booking> getMyVehicleRequests(long id);

	int checkVehicleBooking(Booking booking, long id);

	int checkDriverBooking(Booking booking, long id);

	List<Booking> getMyDriverBookings(long id);

	List<Booking> getMyDriverRequests(long id);

	int isVehicleBooked(long id);

	List<Booking> getAllVehiclesBookings();

	List<Booking> getAllDriverBookings();


}
