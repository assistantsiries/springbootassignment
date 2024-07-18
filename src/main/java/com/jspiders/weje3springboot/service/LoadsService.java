package com.jspiders.weje3springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.weje3springboot.pojo.LoadsPojo;
import com.jspiders.weje3springboot.repository.LoadsRepository;

@Service
public class LoadsService {

	@Autowired
	private LoadsRepository repository;

	public LoadsPojo addLoadData(LoadsPojo load) {
		LoadsPojo pojo = repository.save(load);
		return pojo;
	}

	public List<LoadsPojo> findLoadByShipperId(String shipperId) {
		List<LoadsPojo> loads = repository.findByShipperId(shipperId);
		return loads;
	}

	public LoadsPojo findLoad(long loadId) {
		LoadsPojo pojo = repository.findById(loadId).orElse(null);
		return pojo;
	}

	public LoadsPojo updateLoadData(LoadsPojo loadsPojo) {
		LoadsPojo existingLoad = repository.findById(loadsPojo.getLoadId()).orElse(null);
		existingLoad.setLoadingPoint(loadsPojo.getLoadingPoint());
		existingLoad.setUnloadingPoint(loadsPojo.getUnloadingPoint());
		existingLoad.setProductType(loadsPojo.getProductType());
		existingLoad.setTruckType(loadsPojo.getTruckType());
		existingLoad.setNoOfTrucks(loadsPojo.getNoOfTrucks());
		existingLoad.setComment(loadsPojo.getComment());
		existingLoad.setShipperId(loadsPojo.getShipperId());
		existingLoad.setDate(loadsPojo.getDate());
		repository.save(existingLoad);
		return existingLoad;
	}

	public String deleteLoad(long loadId) {
		repository.deleteById(loadId);
		return "Load data deleted successfully..!!";
	}

//	public LoadsPojo addPersonData(LoadsPojo person) {
//	 LoadsPojo pojo=repository.save(person);
//		return pojo;
//	}
//
//public String deletePersonById(int id) {
//	repository.deleteById(id);
//	return "Person data deleted successfully..!!";
//}
//
//public LoadsPojo updatePersonData(LoadsPojo person) {
//	LoadsPojo existingPerson=repository.findById(person.getId()).orElse(null);
//	existingPerson.setFirstName(person.getFirstName());
//	existingPerson.setLastName(person.getLastName());
//	existingPerson.setCity(person.getCity());
//	repository.save(existingPerson);
	//// @formatter:on
//
//	return existingPerson;
//}

}
