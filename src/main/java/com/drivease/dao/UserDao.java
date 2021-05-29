package com.drivease.dao;

import java.util.List;

import com.drivease.model.Admin;
import com.drivease.model.User;



public interface UserDao extends GenericDAO<User>{

	public long addUser(User user);
	public User getById(long id);
	public List<User> getAll();
	public boolean deleteUser(long id);
	
}
