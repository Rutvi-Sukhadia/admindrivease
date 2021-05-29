package com.drivease.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.VehicleTypeDao;
import com.drivease.model.Admin;
import com.drivease.model.VehicleType;
import com.drivease.service.VehicleTypeService;

@Service("typeservice")
@Transactional
@SessionAttributes("admin")
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Autowired
	VehicleTypeDao typedao;
	
	@Autowired
	HttpSession session;
	
	
	public long addType(VehicleType vehicletype) {
		Admin ad = (Admin) session.getAttribute("admin");
		if(vehicletype.getVehicleTypeId()>=1)
		{
			vehicletype.setModifiedBy(ad.getAdminId());
			vehicletype.setModifiedDate(new Date(System.currentTimeMillis()));
			VehicleType vt = typedao.getById(vehicletype.getVehicleTypeId());
			vehicletype.setCreatedBy(vt.getCreatedBy());
			vehicletype.setCreatedDate(vt.getCreatedDate());
		}
		else
		{
			vehicletype.setCreatedBy(ad.getAdminId());
			vehicletype.setCreatedDate(new Date(System.currentTimeMillis()));
		}
		vehicletype.setIsActive(1);
		vehicletype.setIsDeleted(0);
		return typedao.addType(vehicletype);
	}

	public VehicleType editType(long id) {
		// TODO Auto-generated method stub
		return typedao.editType(id);
	}

	public boolean deleteType(long id) {
		// TODO Auto-generated method stub
		return typedao.deleteType(id);
	}

	public List<VehicleType> getAll() {
		// TODO Auto-generated method stub
		return typedao.getAll();
	}

	public long updateType(VehicleType vehicletype) {
		// TODO Auto-generated method stub
		return 0;
	}

	public VehicleType getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
