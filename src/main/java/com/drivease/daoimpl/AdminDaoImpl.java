package com.drivease.daoimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.AdminDao;
import com.drivease.model.Admin;
import com.drivease.model.VehicleModel;
import com.drivease.util.DbUtility;


@Repository("adminDao")
@SessionAttributes("admin")
public class AdminDaoImpl extends GenericDaoImpl<Admin> implements AdminDao {

	@Autowired
	HttpSession session;
	
	public Admin saveupdateAdmin(Admin admin) {
		
		return super.saveUpdateObject(admin);
	}
	public Admin loginCheck(Admin admin) {
		//List<Admin> list = DbUtility.getListData("SELECT a.fname as fname,a.lname as lname,a.emailId as emailId, a.password as password FROM admin",Admin.class);
		String query = "FROM Admin where emailId='" + admin.getEmailId() + "' and password='" + admin.getPassword() + "'";
		List<Admin> list = super.getByQuery(query);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);

	}
	public int emailCheck(Admin admin) {
		String query = "FROM Admin a where a.emailId='"+admin.getEmailId()+"'";
		List<Admin> list = super.getByQuery(query);
		return list.size();
	}
	
	public List<Admin> getAll() 
	{
		return super.getByQuery("FROM Admin a WHERE a.isDeleted=0");
	}

	public Admin getById(long id)
	{
		return super.getById(Admin.class,id);
	}
	public boolean deleteAdmin(long id) {
		Admin obj = super.getById(Admin.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getAdminId()>0;
	}

	
}

	
	
	
	
	

