package com.drivease.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drivease.dao.PackageDao;
import com.drivease.model.PackageList;

@Repository("packagedao")
public class PackageDaoImpl extends GenericDaoImpl<PackageList> implements PackageDao{

	public List<PackageList> getAll() {
		
		return super.getByQuery("FROM PackageList p WHERE p.isDeleted=0");
	}

	public PackageList getById(long id) {
		
		return super.getById(PackageList.class, id);
	}

	public boolean deletePackage(long id) {
		// TODO Auto-generated method stub
		PackageList obj = super.getById(PackageList.class, id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getPackageId()>0;
	}

	public long addPackage(PackageList pack) {
		
		PackageList new_pack = super.saveUpdateObject(pack);
		return new_pack.getPackageId();
	}

	public List<PackageList> getAllVehiclePackages() {
		return super.getByQuery("FROM PackageList p WHERE p.isDeleted=0 and p.packageType='Vehicle'");
	}

	public List<PackageList> getAllDriverPackages() {
		return super.getByQuery("FROM PackageList p WHERE p.isDeleted=0 and p.packageType='Driver'");
	}

	
	
	

}
