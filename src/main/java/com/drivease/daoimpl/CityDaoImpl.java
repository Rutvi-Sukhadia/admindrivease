package com.drivease.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.drivease.dao.CityDao;
import com.drivease.model.City;
import com.drivease.util.DbUtility;


@Repository("citydao")
public class CityDaoImpl extends GenericDaoImpl<City>  implements CityDao {

	public List<City> getAll(Class<City> T) {
		// TODO Auto-generated method stub
		return null;
	}

	public City getById(Class<City> T, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> getByFieldName(Class<City> T, String fieldName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public City saveObject(City objectToSave) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteObject(City objectToDelete) {
		// TODO Auto-generated method stub
		return null;
	}

	public City updateObject(City objectToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	public City saveUpdateObject(City objectToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> getByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> getByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> saveAllObjects(List<City> objects) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> updateAllObjects(List<City> objects) {
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

	public List<City> getAll() {

		List<City> list = DbUtility.getListData("SELECT c.cityId as cityId, c.cityName as cityName,c.stateId as stateId, s.stateName as stateName FROM city c INNER JOIN state s ON c.stateId = s.stateId WHERE c.isDeleted=0 and s.isDeleted=0", City.class);
		return list;
		//return super.getByQuery("FROM City vm WHERE vm.isDeleted=0");
	}

	public City getById(long id) {
		// TODO Auto-generated method stub
		return super.getById(City.class, id);
	}

	public boolean deleteCity(long id) {
		City obj = super.getById(City.class,id);
		obj.setIsDeleted(1);
		return super.updateObject(obj).getCityId()>0;
	}

	public long addCity(City city) {
		city.setIsActive(1);
		city.setIsDeleted(0);
		City new_obj =super.saveUpdateObject(city);
		return new_obj.getCityId();
	}

	public City editCity(long id) {
		// TODO Auto-generated method stub
		return super.getById(City.class, id);
	}

	public List<City> getAllCitiesByStateId(long stateId) {
		//String query = "SELECT * FROM city c WHERE c.isDeleted = 0 AND c.stateId ="+stateId; 
		List<City> list=DbUtility.getListData("SELECT c.cityId as cityId,c.cityName as cityName FROM city c WHERE c.isDeleted = 0 AND c.stateId ="+stateId, City.class);
		return list;
	}

}
