package com.drivease.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.drivease.model.VehicleCompany;

public interface VehicleCompanyService {
	
	public long addCompany(VehicleCompany company);
	
	public VehicleCompany editCompany(long id);
	public boolean deleteCompany(long id);
	public List<VehicleCompany>getAll();
	public int updateCompany(VehicleCompany company);
	public VehicleCompany getById(long id);

}
