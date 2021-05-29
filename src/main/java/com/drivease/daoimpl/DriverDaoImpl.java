package com.drivease.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.DriverDao;

import com.drivease.model.Driver;
import com.drivease.util.DbUtility;


@Repository("driverdao")
@SessionAttributes("admin")

public class DriverDaoImpl extends GenericDaoImpl<Driver> implements DriverDao {

	public Driver getDriverByUserId(long userId) {
		List<Driver> list = super.getByQuery("From Driver d where d.isDeleted=0 and d.isActive=1 and d.userId="+userId);
		return list.get(0);
	}

	public List<Driver> getAll() {
		List<Driver> list = DbUtility.getListData("SELECT d.driverId as driverId,d.userId as userId,v.vehicleTypeName as vehicleTypeName,d.hourlyRent as hourlyRent, d.dailyRent as dailyRent, d.status as status FROM driver d INNER JOIN vehicle_type v ON d.vehicleTypeId = v.vehicleTypeId where d.isDeleted=0 and d.isAvailable=1 and d.isActive=1",Driver.class);
		//List<Driver> list = super.getByQuery("From Driver d where d.isDeleted=0 and d.isAvailable=1");
		//return super.getByQuery("FROM Vehicle v WHERE v.isDeleted=0");
		return list;
	}

}
