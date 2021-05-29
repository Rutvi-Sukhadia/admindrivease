package com.drivease.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.VehicleCompanyDao;
import com.drivease.model.Admin;
import com.drivease.model.VehicleCompany;
import com.drivease.service.VehicleCompanyService;

@Service("companyservice")
@Transactional
@SessionAttributes("admin")
public class VehicleCompanyServiceImpl implements VehicleCompanyService{

	@Autowired
	VehicleCompanyDao companydao;
	
	@Autowired
	HttpSession session;
	
	
	public long addCompany(VehicleCompany company) {
		Admin ad = (Admin)session.getAttribute("admin");
		if(company.getCompanyId()>=1)
		{
			company.setModifiedBy(ad.getAdminId());
			company.setModifiedDate(new Date(System.currentTimeMillis()));
		}
		else
		{
			company.setCreatedBy(ad.getAdminId());
			company.setCreatedDate(new Date(System.currentTimeMillis()));
		}
		company.setIsActive(1);
		company.setIsDeleted(0);
		return companydao.addCompany(company);
	}

	public VehicleCompany editCompany(long id) {
		// TODO Auto-generated method stub
		return companydao.getById(id);
	}

	public boolean deleteCompany(long id) {
		// TODO Auto-generated method stub
		
		return companydao.deleteCompany(id);
	}

	public List<VehicleCompany> getAll() {
		// TODO Auto-generated method stub
		
		return companydao.getAll();
	}

	public int updateCompany(VehicleCompany company) {
		// TODO Auto-generated method stub
		return 0;
	}

	public VehicleCompany getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
