package com.drivease.dao;



import java.util.List;

import com.drivease.model.MainMenu;



public interface MenuDao extends GenericDAO<MainMenu> {

	public MainMenu saveUpdateAdmin(MainMenu mainMenu);

	public MainMenu editAdmin(long id);

	public boolean deleteAdmin(long id);

	public List<MainMenu> getAll();


}
