package com.drivease.dao;

import java.util.List;

import com.drivease.model.Driver;

public interface DriverDao extends GenericDAO<Driver>{

	Driver getDriverByUserId(long userId);

	public List<Driver> getAll();

}
