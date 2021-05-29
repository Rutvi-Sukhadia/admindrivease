package com.drivease.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.drivease.model.MainMenu;



public interface MenuService {

	public long saveUpdateMenu(MainMenu mainMenu, MultipartFile file);
	public MainMenu editMenu(long id);
	public boolean deleteMenu(long id);
	public List<MainMenu> getAll();
}
