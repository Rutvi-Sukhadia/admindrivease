package com.drivease.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drivease.dao.GenericDAO;
import com.drivease.dao.UserDao;
import com.drivease.model.Admin;
import com.drivease.model.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public long addUser(User user) {
		user.setIsActive(1);
		user.setIsDeleted(0);
		
		return super.saveUpdateObject(user).getUserId();
	}

	public User getById(long id) {
		return super.getById(User.class,id);
		
	}

	public List<User> getAll() {
		
		return super.getByQuery("FROM User u WHERE u.isDeleted=0");
	}

	public boolean deleteUser(long id) {
		User obj = super.getById(User.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getUserId()>0;
	}

	

	

	


	

	
	

	

}
