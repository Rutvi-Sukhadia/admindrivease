package com.drivease.dao;

import java.util.List;

import com.drivease.model.Area;

public interface AreaDao extends GenericDAO<Area>{
	public List<Area> getAll();
	public Area getById(long id);
	public boolean deleteArea(long id);
	public long addArea(Area area);
	public Area editArea(long id);
	public Area getAllDetails(long areaId);
	
}
