package com.drivease.daoimpl;



import java.util.List;
import org.springframework.stereotype.Repository;

import com.drivease.dao.MenuDao;
import com.drivease.model.MainMenu;

@Repository("menuDao")
public class MenuDaoImpl extends GenericDaoImpl<MainMenu> implements MenuDao {

	public MainMenu saveUpdateAdmin(MainMenu mainMenu) {
		// TODO Auto-generated method stub
		return super.saveUpdateObject(mainMenu);
	}

	public MainMenu editAdmin(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MainMenu> getAll() {
		return (List<MainMenu>) super.getByQuery("FROM MainMenu a WHERE a.isDeleted=0");
	}

	public boolean deleteAdmin(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
