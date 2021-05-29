package com.drivease.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.drivease.model.License;

@Service("licenseService")
public interface LicenseService {

		License getLicenseByDriverId(long licenseId);

}
