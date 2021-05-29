package com.drivease.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.drivease.model.Vehicle;

@Service("vehicleservice")
public interface VehicleService {

	public List<Vehicle> getAll();

	Vehicle getAllDetails(long id);

	public Vehicle getById(long id);
	

}
