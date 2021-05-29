package com.drivease.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.drivease.model.User;



public interface UserService {

	public long addUser(User user, MultipartFile file1);
	public int saveUser(User user, MultipartFile file1);
	public User getById(long id);
	public boolean deleteUser(long id);
	public List<User>getAll();
	public User getAllDetails(long id);
	
}
