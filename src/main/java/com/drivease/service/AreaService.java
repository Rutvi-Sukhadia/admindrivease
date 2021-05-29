package com.drivease.service;

import java.util.List;

import com.drivease.model.Area;

public interface AreaService {
	
	public long addArea(Area area);
	
	public Area editArea(long id);
	public boolean deleteArea(long id);
	public List<Area> getAll();
	public int updateArea(Area area);
	public Area getById(long id);

}
