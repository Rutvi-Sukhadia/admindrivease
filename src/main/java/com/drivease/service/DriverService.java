package com.drivease.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.drivease.model.Driver;

public interface DriverService {

	Driver getDriverByUserId(long userId);

	Driver getAllDetails(long driverId);

	public List<Driver> getAll();

	Driver getById(long driverId);

}
