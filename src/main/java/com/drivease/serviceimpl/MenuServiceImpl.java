package com.drivease.serviceimpl;



import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.drivease.dao.MenuDao;
import com.drivease.model.MainMenu;
import com.drivease.service.MenuService;
import com.drivease.util.FTPUtils;
import com.drivease.util.FileUtils;


@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao menuDao;
	
	//private static String UPLOADED_FOLDER1 = File.separator + "resources" + File.separator + "images" + File.separator;
	//private static String UPLOADED_FOLDER1 = "E://testFiles//";
	private static String UPLOADED_FOLDER1 = "E://tools//apache-tomcat-9.0.11-windows-x64//apache-tomcat-9.0.11//webapps//digitalmenu//resources//images//";
	
	public long saveUpdateMenu(MainMenu mainMenu, MultipartFile file) {
		String newFileName = FileUtils.getFileName(file.getOriginalFilename());
		mainMenu.setIsActive(1);
		mainMenu.setMenuImage(newFileName);
		MainMenu mainMenu1 = menuDao.saveUpdateAdmin(mainMenu);
		if(mainMenu != null)
		{
			FileUtils.uploadImageFile(file, UPLOADED_FOLDER1+newFileName);
			FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newFileName, newFileName);
		}
		
		return 0;
	}

	public MainMenu editMenu(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteMenu(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<MainMenu> getAll() {
		List<MainMenu> menuList = menuDao.getAll();
		for (MainMenu mainMenu : menuList) {
			String fileName = mainMenu.getMenuImage();
			File file = new File(UPLOADED_FOLDER1+fileName);
			if(!file.exists())
			{
				FTPUtils.download(fileName, UPLOADED_FOLDER1+fileName);
			}
		}
		return menuList;
	}

}

