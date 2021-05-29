package com.drivease.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.drivease.model.Admin;



public interface AdminService {
	
	
	public boolean deleteAdmin(long id);
	
	public List<Admin>getAll();
	
	public long saveupdateAdmin(Admin admin, MultipartFile file1);
	
	public long updateAdmin(Admin admin, MultipartFile file1);
	
	public Admin getById(long id);

	public long saveAdmin(Admin admin, MultipartFile file1);
	
	

	
	
}
