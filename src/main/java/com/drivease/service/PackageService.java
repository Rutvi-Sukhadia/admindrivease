package com.drivease.service;

import java.util.List;

import com.drivease.model.PackageList;


public interface PackageService {

	public long addPackage(PackageList pack);
	public PackageList editPackage(long id);
	public boolean deletePackage(long id);
	public List<PackageList>getAll();
	public int updatePackage(PackageList pack);
	public PackageList getById(long id);
	public List<PackageList> getAllVehiclePackages();
	public List<PackageList> getAllDriverPackages();

}
