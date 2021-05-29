package com.drivease.dao;

import java.util.List;

import com.drivease.model.VehicleModel;

public interface VehicleModelDao extends GenericDAO<VehicleModel>{
	public List<VehicleModel> getAll();
	public VehicleModel getById(long id);
	public boolean deleteModel(long id);
	public long addModel(VehicleModel vehiclemodel);
	public VehicleModel editModel(long id);
	public VehicleModel getAllDetails(long modelId);
	
}
