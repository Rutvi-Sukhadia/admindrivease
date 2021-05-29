package com.drivease.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drivease.dao.VehicleCompanyDao;
import com.drivease.model.VehicleCompany;


@Repository("vehicleCompanyDao")
public class VehicleCompanyDaoImpl extends GenericDaoImpl<VehicleCompany> implements VehicleCompanyDao{

	public List<VehicleCompany> getAll() {
		// TODO Auto-generated method stub
		return super.getByQuery("FROM VehicleCompany vc WHERE vc.isDeleted=0");
	}

	public VehicleCompany getById(long id) {
		// TODO Auto-generated method stub
		return super.getById(VehicleCompany.class,id);
	}

	public boolean deleteCompany(long id) {
		VehicleCompany obj = super.getById(VehicleCompany.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getCompanyId()>0;
	}

	public long addCompany(VehicleCompany company) {
		
		VehicleCompany new_obj =super.saveUpdateObject(company);
		return new_obj.getCompanyId();
	
	}
	
}