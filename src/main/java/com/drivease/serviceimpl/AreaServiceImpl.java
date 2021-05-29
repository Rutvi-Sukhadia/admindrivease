package com.drivease.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.drivease.dao.AreaDao;
import com.drivease.model.Admin;
import com.drivease.model.Area;
import com.drivease.service.AreaService;

@Service("areaservice")
@Transactional
@SessionAttributes("admin")
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaDao areadao;
	
	@Autowired
	HttpSession session;
	
	public long addArea(Area area) {
		Admin ad=(Admin)session.getAttribute("admin");
		if(area.getAreaId()<=1)
		{
			area.setCreatedBy(ad.getAdminId());
			area.setCreatedDate(new Date(System.currentTimeMillis()));
		}
		else
		{
			area.setModifiedBy(ad.getAdminId());
			area.setModifiedDate(new Date(System.currentTimeMillis()));
		}
		
		return areadao.addArea(area);
	}

	public Area editArea(long id) {
		// TODO Auto-generated method stub
		return areadao.editArea(id);
	}

	public boolean deleteArea(long id) {
		// TODO Auto-generated method stub
		return areadao.deleteArea(id);
	}

	public List<Area> getAll() {
		// TODO Auto-generated method stub
		return areadao.getAll();
	}

	public int updateArea(Area area) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Area getById(long id) {
		// TODO Auto-generated method stub
		return areadao.getById(id);
	}

}
