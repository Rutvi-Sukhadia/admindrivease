package com.drivease.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.drivease.dao.AreaDao;
import com.drivease.model.Area;
import com.drivease.util.DbUtility;

@Repository("areadao")
public class AreaDaoImpl extends GenericDaoImpl<Area>  implements AreaDao {

	public List<Area> getAll(Class<Area> T) {
		// TODO Auto-generated method stub
		return null;
	}

	public Area getById(Class<Area> T, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> getByFieldName(Class<Area> T, String fieldName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Area saveObject(Area objectToSave) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteObject(Area objectToDelete) {
		// TODO Auto-generated method stub
		return null;
	}

	public Area updateObject(Area objectToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	public Area saveUpdateObject(Area objectToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> getByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> getByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> saveAllObjects(List<Area> objects) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> updateAllObjects(List<Area> objects) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteByQuery(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByQuery(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Area> getAll() {

		List<Area> list = DbUtility.getListData("SELECT a.areaId as areaId,"
				+ " a.areaName as areaName,c.cityName as cityName, s.stateName as stateName "
				+ "FROM area a INNER JOIN city c ON a.cityId = c.cityId INNER JOIN state s"
				+ " ON c.stateId = s.stateId  WHERE a.isDeleted=0 and c.isDeleted=0 and "
				+ "s.isDeleted=0", Area.class);
		return list;
		//return super.getByQuery("FROM Area vm WHERE vm.isDeleted=0");
	}

	public Area getById(long id) {
		// TODO Auto-generated method stub
		return super.getById(Area.class, id);
	}

	public boolean deleteArea(long id) {
		Area obj = super.getById(Area.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getAreaId()>0;
	}

	public long addArea(Area area) {
		area.setIsActive(1);
		area.setIsDeleted(0);
		Area new_obj =super.saveUpdateObject(area);
		return new_obj.getAreaId();
	}

	public Area editArea(long id) {
		// TODO Auto-generated method stub
		return super.getById(Area.class, id);
		
	}
	
	public Area getAllDetails(long areaId) {
		List<Area> list = DbUtility.getListData("SELECT a.areaId as areaId,"
				+ " a.areaName as areaName,c.cityId as cityId,c.cityName as cityName,"
				+ "s.stateId as stateId, s.stateName as stateName "
				+ "FROM area a INNER JOIN city c ON a.cityId = c.cityId INNER JOIN state s"
				+ " ON c.stateId = s.stateId  WHERE a.isDeleted=0 and c.isDeleted=0 and "
				+ "s.isDeleted=0 and a.areaId="+areaId, Area.class);
		return list.get(0);
	}

}
