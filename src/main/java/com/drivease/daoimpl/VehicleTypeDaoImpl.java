package com.drivease.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drivease.dao.VehicleTypeDao;
import com.drivease.model.VehicleType;


@Repository("vehicleTypeDao")
public class VehicleTypeDaoImpl extends GenericDaoImpl<VehicleType> implements VehicleTypeDao{

	public List<VehicleType> getAll() {

		return super.getByQuery("FROM VehicleType vt WHERE vt.isDeleted=0");
	}

	public VehicleType getById(long id) {
	
		return super.getById(VehicleType.class,id);
	}

	public boolean deleteType(long id) {
		VehicleType obj = super.getById(VehicleType.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getVehicleTypeId()>0;
	}

	public long addType(VehicleType vehicletype) {
		
		VehicleType new_obj =super.saveUpdateObject(vehicletype);
		return new_obj.getVehicleTypeId();
	
	}

	public VehicleType editType(long id) {
		return super.getById(VehicleType.class,id);
	}
	
}