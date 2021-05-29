package com.drivease.service;

import java.util.List;

import com.drivease.model.VehicleModel;

public interface VehicleModelService {
	
	public long addModel(VehicleModel vehiclemodel);
	
	public VehicleModel editModel(long id);
	public boolean deleteModel(long id);
	public List<VehicleModel>getAll();
	public int updateModel(VehicleModel vehiclemodel);
	public VehicleModel getById(long id);

}
