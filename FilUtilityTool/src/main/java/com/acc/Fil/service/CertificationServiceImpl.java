
package com.acc.Fil.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.Fil.dao.CertificationDao;
import com.acc.Fil.entity.CertificationEntity;

@Service
public class CertificationServiceImpl  {

	@Autowired
	private CertificationDao certDaoWrapper;

	@SuppressWarnings("unchecked")
	public List getAllCertification() {
		List certification = new ArrayList<>();
	certDaoWrapper.findAll().forEach(certification::add);
		return certification;
	}
	public Object getCertification(int id) {
		return certDaoWrapper.findById(id);
	}
	public void addCertification(CertificationEntity centity) {
		certDaoWrapper.save(centity);
	}
	
	public void updateCertification(int id, CertificationEntity centity) {
		

		CertificationEntity centity2=certDaoWrapper.findById(id).get();
		
		centity2.setCertificationName(centity.getCertificationName());
		centity2.setCertificationDesc(centity.getCertificationDesc());
		centity2.setCertificationStatus(centity.getCertificationStatus());
		centity2.setCertificationType(centity.getCertificationType());
		centity2.setStartDate(centity.getStartDate());
		centity2.setCompleteDate(centity.getCompleteDate());
		
		certDaoWrapper.save(centity2);
	}
	
	
	public void deleteCertification(int id) {
		certDaoWrapper.deleteById(id);;
	}
	

}