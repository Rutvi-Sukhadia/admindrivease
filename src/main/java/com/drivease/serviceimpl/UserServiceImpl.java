package com.drivease.serviceimpl;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.drivease.dao.AreaDao;
import com.drivease.dao.UserDao;
import com.drivease.model.Admin;
import com.drivease.model.Area;
import com.drivease.model.User;
import com.drivease.service.UserService;
import com.drivease.util.FTPUtils;
import com.drivease.util.FileUtils;
import com.drivease.util.Mailer;
import com.drivease.util.PasswordEncode;
import com.drivease.util.RandomString;

@Service("userservice")
@Transactional
@SessionAttributes("admin")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	AreaDao areadao;
	
	 String absolutePath1 = ""; 
	    //private static String UPLOADED_FOLDER1 ="D://tools//apache-tomcat-9.0.11-windows-x64//apache-tomcat-9.0.11//webapps//userdrivease//resources//images//profilePicture"+File.separator;
		private static String UPLOADED_FOLDER ="D://Tools//apache-tomcat-9.0.11//webapps//admindrivease//resources//images//userProfilePicture"+File.separator;

	public long addUser(User user, MultipartFile file1) {
		String newPP=FileUtils.getFileName(file1.getOriginalFilename());
		user.setProfilePicture(newPP);
		user.setProfileImage(file1);
		String password = RandomString.getAlphaNumericString(8);
		Admin ud=(Admin)session.getAttribute("admin");
		user.setIsActive(1);
		user.setCreatedDate(new Date(System.currentTimeMillis()));
		//user.setCreatedBy(ud.getAdminId());
		//user.setModifiedDate(new Date(System.currentTimeMillis()));
		//int result = userdao.emailCheck(user);
		/*if(result!=0)
		{
			return 1;
		}*/
		if (user != null) {
		
			user.setPassword(PasswordEncode.passwordEncode(password));
		}

		User a=userdao.saveObject(user);
		if(a!=null)
		{
			Mailer.send("drivease2419@gmail.com", "drivEase@1924",user.getEmailId(), "Welcome to DrivEase! "," Hello,Your password is"+password);
			
			FileUtils.uploadImageFile(file1, UPLOADED_FOLDER+newPP);
			FTPUtils.uploadOnFTP(UPLOADED_FOLDER+newPP, newPP);
			return a.getUserId();
		}else {
		return 0;
		}
	}

	public int saveUser(User user, MultipartFile file1) {
		user.setProfilePicture(FileUtils.getFileName(file1.getOriginalFilename()));
		userdao.updateObject(user);
		FileUtils.uploadFile(file1, "/resources/images/profilePicture");
		return 0;
	}

	public User getById(long id) {
		User user = userdao.getById(User.class, id);
		return user;
	}

	public boolean deleteUser(long id) {
		return userdao.deleteUser(id);
	}

	public List<User> getAll() {
		return userdao.getAll();
	}

	public User getAllDetails(long userId) {
		User u = userdao.getById(User.class, userId);
		String newPP = u.getProfilePicture();
		File ProfileImage = new File(UPLOADED_FOLDER+newPP);
		if(!ProfileImage.exists())
		{
			FTPUtils.download(newPP, UPLOADED_FOLDER+newPP);
		}
		Area a = areadao.getAllDetails(u.getAreaId());
		u.setStateId(a.getStateId());
		u.setStateName(a.getStateName());
		u.setCityId(a.getCityId());
		u.setCityName(a.getCityName());
		u.setAreaName(a.getAreaName());
		return u;
	}

}
