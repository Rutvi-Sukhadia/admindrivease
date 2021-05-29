package com.drivease.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.VehicleModelDao;
import com.drivease.model.Admin;
import com.drivease.model.VehicleModel;
import com.drivease.service.VehicleModelService;

@Service("modelservice")
@Transactional
@SessionAttributes("admin")
public class VehicleModelServiceImpl implements VehicleModelService {

	@Autowired
	VehicleModelDao modeldao;
	@Autowired
	HttpSession session;
	
	
	public long addModel(VehicleModel vehiclemodel) {
		Admin ad = (Admin)session.getAttribute("admin");
		if(vehiclemodel.getModelId()<=0) {
			vehiclemodel.setCreatedBy(ad.getAdminId());
			vehiclemodel.setCreatedDate(new Date(System.currentTimeMillis()));
		}else{
			vehiclemodel.setModifiedBy(ad.getAdminId());
			vehiclemodel.setModifiedDate(new Date(System.currentTimeMillis()));
		}
		vehiclemodel.setIsActive(1);
		vehiclemodel.setIsDeleted(0);
		return modeldao.addModel(vehiclemodel);
	}

	public VehicleModel editModel(long id) {
		// TODO Auto-generated method stub
		return modeldao.editModel(id);
	}

	public boolean deleteModel(long id) {
		// TODO Auto-generated method stub
		return modeldao.deleteModel(id);
	}

	public List<VehicleModel> getAll() {
		// TODO Auto-generated method stub
		return modeldao.getAll();
	}

	public int updateModel(VehicleModel vehiclemodel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public VehicleModel getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
