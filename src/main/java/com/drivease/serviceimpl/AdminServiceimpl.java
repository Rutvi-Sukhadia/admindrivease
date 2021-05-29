


package com.drivease.serviceimpl;

import java.io.File;
import java.nio.file.Files;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import com.drivease.dao.AdminDao;
import com.drivease.model.Admin;
import com.drivease.service.AdminService;
import com.drivease.util.FileUtils;
import com.drivease.util.Mailer;
import com.drivease.util.PasswordEncode;
import com.drivease.util.RandomString;
import com.drivease.util.FTPUtils;


@Service("adminService")
@Transactional
@SessionAttributes("admin")
public class AdminServiceimpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	HttpSession session;
	
	 String absolutePath1 = ""; 
	//private static String UPLOADED_FOLDER1 ="D://tools//apache-tomcat-9.0.11-windows-x64//apache-tomcat-9.0.11//webapps//admindrivease//resources//images//profilePicture"+File.separator;
	private static String UPLOADED_FOLDER1 ="D://Tools//apache-tomcat-9.0.11//webapps//admindrivease//resources//images//profilePicture"+File.separator;

	public long saveAdmin(Admin admin, MultipartFile file1) {
		String newPP=FileUtils.getFileName(file1.getOriginalFilename());
		admin.setProfilePicture(newPP);
		admin.setProfileImage(file1);
		String password = RandomString.getAlphaNumericString(8);
		Admin ad=(Admin)session.getAttribute("admin");
		admin.setIsActive(1);
		if(admin.getAdminId()<=1){
			admin.setCreatedBy(ad.getAdminId());
			admin.setCreatedDate(new Date(System.currentTimeMillis()));
		}else {
			admin.setModifiedBy(ad.getAdminId());
			admin.setModifiedDate(new Date(System.currentTimeMillis()));
		}
		int result = adminDao.emailCheck(admin);
		if(result!=0)
		{
			return 0;
		}
		if (admin != null) {
			
			admin.setPassword(PasswordEncode.passwordEncode(password));
		}
	
		Admin a=adminDao.saveObject(admin);
		if(a!=null)
		{
			Mailer.send("drivease2419@gmail.com", "drivEase@1924", admin.getEmailId(), "Hello,Your password is ", password);
			FileUtils.uploadImageFile(file1, UPLOADED_FOLDER1+newPP);
			FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newPP, newPP);
			return a.getAdminId();
		}
		return 0;
	}

	

	public long saveupdateAdmin(Admin admin, MultipartFile file1) {
		
		admin.setProfilePicture(FileUtils.getFileName(file1.getOriginalFilename()));
		admin.setIsActive(1);
		String password = RandomString.getAlphaNumericString(8);
		if(admin!=null)
		{
			admin.setPassword(PasswordEncode.passwordEncode(password));
			FileUtils.uploadImageFile(file1, UPLOADED_FOLDER1);
		}
		
		Admin newAdmin = adminDao.saveupdateAdmin(admin);
		//Admin a = adminDao.saveObject(admin);
		if(admin!=null)
		{
			Mailer.send("drivease2419@gmail.com", "drivEase@1924", admin.getEmailId(), "Hello,Your password is ", password);
		}

		
		return 0;
	}


	public List<Admin> getAll() {
		return adminDao.getAll();
	}
	
	public Admin getById(long id) {
		Admin admin = adminDao.getById(Admin.class, id);
		String newPP = admin.getProfilePicture();
		
		File ProfileImage = new File(UPLOADED_FOLDER1+newPP);
		if(!ProfileImage.exists())
		{
			FTPUtils.download(newPP, UPLOADED_FOLDER1+newPP);
		
		}
		return admin;

	}
	public long updateAdmin(Admin admin, MultipartFile file1) {
		Admin oldad=adminDao.getById(Admin.class,admin.getAdminId());
		Admin ad = (Admin) session.getAttribute("admin");
		admin.setCreatedBy(oldad.getCreatedBy());
		admin.setPassword(oldad.getPassword());
		admin.setIsActive(1);
		admin.setCreatedDate(oldad.getCreatedDate());
		admin.setModifiedBy(ad.getAdminId());
		admin.setModifiedDate(new Date(System.currentTimeMillis()));
		if(file1.isEmpty()) {
			admin.setProfilePicture(oldad.getProfilePicture());
		}
		else if(!oldad.getProfilePicture().equals(file1.getOriginalFilename()))
		{
			String newPP = FileUtils.getFileName(file1.getOriginalFilename());
			FileUtils.uploadImageFile(file1, UPLOADED_FOLDER1+newPP);
			FTPUtils.uploadOnFTP(UPLOADED_FOLDER1+newPP, newPP);
			admin.setProfilePicture(newPP);
		}
		Admin a1 = adminDao.updateObject(admin);
		
		return a1.getAdminId();
	}



	public boolean deleteAdmin(long id) {
		return adminDao.deleteAdmin(id);
	}

	
}
	
	
	



	

	
	

