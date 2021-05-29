package com.drivease.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drivease.dao.VehicleDao;

import com.drivease.model.Vehicle;
import com.drivease.util.DbUtility;

@Repository("vehicleDao")
public class VehicleDaoImpl extends GenericDaoImpl<Vehicle> implements VehicleDao {

	public List<Vehicle> checkVehicleNo(String vehicleNo) {
		//String query = "FROM Vehicle where vehicleNumber='" + vehicleNo + "'";
		List<Vehicle> list = super.getByQuery("FROM Vehicle where vehicleNumber=" + vehicleNo);
		return list;
	}

	public List<Vehicle> getAll() {
		List<Vehicle> list = DbUtility.getListData("SELECT v.vehicleId as vehicleId,u.userId as userId,u.fname as lenderName, v.vehicleNumber as vehicleNumber,m.modelName as modelName,c.companyName as companyName, v.pickUpAdd as pickUpAdd,v.hourlyRent as hourlyRent, v.dailyRent as dailyRent, v.status as status,v.vehiclePicture as vehiclePicture FROM vehicle v INNER JOIN vehicle_model m ON v.modelId = m.modelId INNER JOIN vehicle_company c ON m.companyId = c.companyId INNER JOIN user u ON u.userId=v.userId where v.isDeleted=0 and v.isAvailable=1 ",Vehicle.class);
		//List<Vehicle> list = super.getByQuery("From Vehicle v where v.isDeleted=0");
		return list;
		
	}
	

}
