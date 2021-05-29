package com.drivease.dao;

import java.util.List;

import com.drivease.model.VehicleType;

public interface VehicleTypeDao extends GenericDAO<VehicleType>{
	public List<VehicleType> getAll();
	public VehicleType getById(long id);
	public boolean deleteType(long id);
	public long addType(VehicleType vehicletype);
	public VehicleType editType(long id);
	
}
