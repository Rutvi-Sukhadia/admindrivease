package com.drivease.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.PackageDao;
import com.drivease.model.Admin;
import com.drivease.model.PackageList;
import com.drivease.model.VehicleType;
import com.drivease.service.PackageService;

@Service("packageservice")
@Transactional
@SessionAttributes("admin")
public class PackageServiceImpl implements PackageService {
	
	@Autowired
	PackageDao packagedao;
	
	@Autowired
	HttpSession session;

	public long addPackage(PackageList pack) {
		Admin ad = (Admin) session.getAttribute("admin");
		if(pack.getPackageId()>=1)
		{
			pack.setModifiedBy(ad.getAdminId());
			pack.setModifiedDate(new Date(System.currentTimeMillis()));
			PackageList p = packagedao.getById(pack.getPackageId());
			pack.setCreatedBy(p.getCreatedBy());
			pack.setCreatedDate(p.getCreatedDate());
		}
		else
		{
			pack.setCreatedBy(ad.getAdminId());
			pack.setCreatedDate(new Date(System.currentTimeMillis()));
		}
		pack.setIsActive(1);
		pack.setIsDeleted(0);
		
	return packagedao.addPackage(pack);
		
	}

	public PackageList editPackage(long id) {
		// TODO Auto-generated method stub
		return packagedao.getById(id);
	}

	public boolean deletePackage(long id) {
		// TODO Auto-generated method stub
		return packagedao.deletePackage(id);
	}

	public List<PackageList> getAll() {
		
		return packagedao.getAll();
	}

	public int updatePackage(PackageList pack) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PackageList getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PackageList> getAllVehiclePackages() {
		return packagedao.getAllVehiclePackages();
	}

	public List<PackageList> getAllDriverPackages() {
		return packagedao.getAllDriverPackages();
	}
	
	

}
