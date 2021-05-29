package com.drivease.dao;

import java.util.List;

import com.drivease.model.PackageList;


public interface PackageDao extends GenericDAO<PackageList> {
	public List<PackageList> getAll();
	public PackageList getById(long id);
	public boolean deletePackage(long id);
	public long addPackage(PackageList pack);
	public List<PackageList> getAllVehiclePackages();
	public List<PackageList> getAllDriverPackages();

}
