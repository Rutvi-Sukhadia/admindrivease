package com.drivease.serviceimpl;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.drivease.dao.AreaDao;
import com.drivease.dao.UserDao;
import com.drivease.dao.VehicleDao;
import com.drivease.dao.VehicleModelDao;
import com.drivease.model.Vehicle;
import com.drivease.model.VehicleModel;
import com.drivease.model.Area;
import com.drivease.model.User;
import com.drivease.service.VehicleService;

import com.drivease.util.FTPUtils;
import com.drivease.util.FileUtils;


@Service("vehicleservice")
@Transactional
@SessionAttributes("admin")
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleDao vehicledao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	VehicleModelDao vehiclemodeldao;
	
	@Autowired
	AreaDao areadao;
	
	
	String absolutePath1 = "";
	//private static String UPLOADED_FOLDER2 ="D://tools//apache-tomcat-9.0.11-windows-x64//apache-tomcat-9.0.11//webapps//userdrivease//resources//images//vehiclePicture"+File.separator;
		private static String UPLOADED_FOLDER2 ="D://Tools//apache-tomcat-9.0.11//webapps//admindrivease//resources//images//vehiclePicture"+File.separator;
		
		//private static String UPLOADED_FOLDER1 ="D://tools//apache-tomcat-9.0.11-windows-x64//apache-tomcat-9.0.11//webapps//userdrivease//resources//images//vehiclePicture"+File.separator;
		private static String UPLOADED_FOLDER1 ="D://Tools//apache-tomcat-9.0.11//webapps//admindrivease//resources//images//userProfilePicture"+File.separator;
		
	public List<Vehicle> getAll() {
		return vehicledao.getAll();
	}

	public Vehicle getAllDetails(long id) {
		Vehicle v= vehicledao.getById(Vehicle.class,id);
		String newPP = v.getVehiclePicture();
		
		File VehicleImage = new File(UPLOADED_FOLDER2+newPP);
		if(!VehicleImage.exists())
		{
			FTPUtils.download(newPP, UPLOADED_FOLDER2+newPP);
		
		}
		
		User u = userdao.getById(User.class,v.getUserId());
		v.setLenderName(u.getFname()+" "+u.getLname());
		v.setLenderMobile(u.getMobileNo());
		v.setLenderEmail(u.getEmailId());
		String newPP1 = u.getProfilePicture();
		File ProfileImage = new File(UPLOADED_FOLDER1+newPP1);
		if(!ProfileImage.exists())
		{
			FTPUtils.download(newPP1, UPLOADED_FOLDER1+newPP1);
		}
		v.setLenderPicture(u.getProfilePicture());
		VehicleModel vm = vehiclemodeldao.getAllDetails(v.getModelId());
		v.setCompanyId(vm.getCompanyId());
		v.setCompanyName(vm.getCompanyName());
		v.setModelName(vm.getModelName());
		v.setVehicleTypeName(vm.getVehicleTypeName());
		Area a = areadao.getAllDetails(v.getAreaId());
		v.setStateId(a.getStateId());
		v.setStateName(a.getStateName());
		v.setCityId(a.getCityId());
		v.setCityName(a.getCityName());
		v.setAreaName(a.getAreaName());
		return v;
	}

	public Vehicle getById(long id) {
		return vehicledao.getById(Vehicle.class, id);
	}
	
	
	

}
