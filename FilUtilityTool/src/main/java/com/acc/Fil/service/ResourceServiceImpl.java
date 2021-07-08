
package com.acc.Fil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.Fil.dao.ResourceDao;
import com.acc.Fil.entity.CertificationEntity;
import com.acc.Fil.entity.ResourceEntity;
import com.acc.Fil.entity.TrainingEntity;

@Service
public class ResourceServiceImpl {

	@Autowired
	private ResourceDao resourceDaoWrapper;

	@SuppressWarnings("unchecked")
	public List getAllResource() {
		List resource = new ArrayList<>();
	resourceDaoWrapper.findAll().forEach(resource::add);
		return resource;
	}
	public Object getResource(int id) {
		return resourceDaoWrapper.findById(id);
	}
	public void addResource(ResourceEntity rentity) {
		resourceDaoWrapper.save(rentity);
	}
	
	public void updateResource(int id, ResourceEntity rentity) {
	ResourceEntity rentity2=	resourceDaoWrapper.findById(id).get();
		rentity2.setAccentureId(rentity.getAccentureId());
		rentity2.setFilId(rentity.getFilId());
		rentity2.setAccentureJoiningDate(rentity.getAccentureJoiningDate());
		rentity2.setFilJoiningDate(rentity.getFilJoiningDate());
		
		resourceDaoWrapper.save(rentity2);
	}
	public void deleteResource(int id) {
		resourceDaoWrapper.deleteById(id);;
	}
	
}