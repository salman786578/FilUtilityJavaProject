package com.acc.Fil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.Fil.entity.CertificationEntity;
import com.acc.Fil.service.CertificationServiceImpl;

@RestController
public class CertificationController {

	@Autowired
	private CertificationServiceImpl certificateServiceImpl;

	@RequestMapping(value = "/filTools/v1/certificate/getDetails", method = RequestMethod.GET)
	public List getAllCertification() {
		return certificateServiceImpl.getAllCertification();
	}
	
	@RequestMapping(value = "/filTools/v1/certificate/getDetailsById/{id}", method = RequestMethod.GET)
	public Object getCertification(@PathVariable int id) {
		return  certificateServiceImpl.getCertification(id);
	}
	
	@RequestMapping(value = "/filTools/v1/certificate/addCertificate", method =RequestMethod.POST)
	public void addCertification(@RequestBody CertificationEntity centity) {
		certificateServiceImpl.addCertification(centity);;
	}
	
	@RequestMapping(value = "/filTools/v1/certificate/updateCertificate/{id}", method = RequestMethod.PUT)
	public void updateCertification(@RequestBody CertificationEntity centity,@PathVariable int id) {
		certificateServiceImpl.updateCertification(id, centity);;
	}
	@RequestMapping(value = "/filTools/v1/certificate/deleteCertificate/{id}", method = RequestMethod.DELETE)
	public void deleteCertification(@PathVariable int id) {
		certificateServiceImpl.deleteCertification(id);;
	}
	
}

