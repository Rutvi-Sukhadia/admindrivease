package com.drivease.serviceimpl;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.drivease.dao.LicenseDao;

import com.drivease.model.License;
import com.drivease.model.User;
import com.drivease.service.LicenseService;

import com.drivease.util.FTPUtils;
import com.drivease.util.FileUtils;


@Service("licenseservice")
@Transactional
@SessionAttributes("admin")
public class LicenseServiceImpl implements LicenseService {
	
	@Autowired
	LicenseDao licensedao;
	
	@Autowired
	HttpSession session;
	
	String absolutePath1 = "";
	//private static String UPLOADED_FOLDER1 ="D://tools//apache-tomcat-9.0.11-windows-x64//apache-tomcat-9.0.11//webapps//userdrivease//resources//images//licensePicture"+File.separator;
	private static String UPLOADED_FOLDER1 ="D://Tools//apache-tomcat-9.0.11//webapps//admindrivease//resources//images//licensePicture"+File.separator;
	
		public License getLicenseByDriverId(long licenseId) {
			return licensedao.getById(License.class,licenseId);
	}
}
	
	
	


