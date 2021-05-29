package com.drivease.service;

import com.drivease.model.Admin;

public interface LoginService {
	
	public Admin login(Admin admin);

	public int changePass(Admin admin);

}
