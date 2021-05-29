package com.drivease.dao;

import java.util.List;

import com.drivease.model.Vehicle;

public interface VehicleDao extends GenericDAO<Vehicle> {


	List<Vehicle> getAll();

}
