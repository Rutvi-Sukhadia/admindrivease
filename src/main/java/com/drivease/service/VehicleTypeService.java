package com.drivease.service;

import java.util.List;

import com.drivease.model.VehicleType;

public interface VehicleTypeService {
	
	public long addType(VehicleType vehicletype);
	
	public VehicleType editType(long id);
	public boolean deleteType(long id);
	public List<VehicleType> getAll();
	public long updateType(VehicleType vehicletype);
	public VehicleType getById(long id);

}
