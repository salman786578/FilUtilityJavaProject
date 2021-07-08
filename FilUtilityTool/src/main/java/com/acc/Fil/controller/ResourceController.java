package com.acc.Fil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.Fil.entity.ResourceEntity;
import com.acc.Fil.service.ResourceServiceImpl;

@RestController
public class ResourceController {

	@Autowired
	private ResourceServiceImpl resourceServiceImpl;
	
	@RequestMapping(value = "/filTools/v1/resource/getDetails", method = RequestMethod.GET)
	public List getAllResource() {
		return resourceServiceImpl.getAllResource();
	}
	
	@RequestMapping(value = "/filTools/v1/resource/getDetailsById/{id}", method = RequestMethod.GET)
	public Object getResource(@PathVariable int id) {
		return  resourceServiceImpl.getResource(id);
	}
	
	@RequestMapping(value = "/filTools/v1/resource/addResource", method =RequestMethod.POST)
	public void addResource(@RequestBody ResourceEntity rentity) {
		resourceServiceImpl.addResource(rentity);
	}
	
	@RequestMapping(value = "/filTools/v1/resource/updateResource/{id}", method = RequestMethod.PUT)
	public void updateResource(@RequestBody ResourceEntity rentity,@PathVariable int id) {
		
		resourceServiceImpl.updateResource(id, rentity);;
	}
	@RequestMapping(value = "/filTools/v1/resource/deleteResource/{id}", method = RequestMethod.DELETE)
	public void deleteResource(@PathVariable int id) {
		resourceServiceImpl.deleteResource(id);;
	}
	
}
