package com.jspiders.weje3springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.jspiders.weje3springboot.pojo.LoadsPojo;
import com.jspiders.weje3springboot.response.LoadsResponse;
import com.jspiders.weje3springboot.service.LoadsService;

@RestController
public class LoadsController {
	
	@Autowired
	private LoadsService service;
	
	//for adding Loads information 
	@PostMapping("/load")
	public ResponseEntity<LoadsResponse> addLoad(@RequestBody LoadsPojo loadPojo){
		LoadsPojo pojo=service.addLoadData(loadPojo);
		if(pojo != null) {
			return new ResponseEntity<LoadsResponse>(new LoadsResponse("Ok", "Loads details added successfully..!!", pojo, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<LoadsResponse>(new LoadsResponse("Fail", "Loads details not added..!!", null, null), HttpStatus.BAD_REQUEST);
		
	}
	//for getting load data depending on shipped Id
	@GetMapping("/loadBySId/{shipperId}")
		public ResponseEntity<LoadsResponse> getLoadById(@PathVariable String shipperId){
		List<LoadsPojo> loads=service.findLoadByShipperId(shipperId);
	    if(loads !=null) {
	    	return new ResponseEntity<LoadsResponse>(new LoadsResponse("Ok", "List of loads with this shipperId..!!", null, loads), HttpStatus.ACCEPTED);
	    }
	    return new ResponseEntity<LoadsResponse>(new LoadsResponse("Fail", "List of loads with this shipperId is not found..!!", null, null), HttpStatus.BAD_REQUEST);
				
	}
	
	//for finding load depending on load Id
	@GetMapping("/load/{loadId}")
	public ResponseEntity<LoadsResponse> findLoadById(@PathVariable long loadId){
		LoadsPojo pojo=service.findLoad(loadId);
		if(pojo !=null) {
			return new ResponseEntity<LoadsResponse>(new LoadsResponse("Ok", "Load data found successfully..!!", pojo, null), HttpStatus.ACCEPTED);
		}
		  return new ResponseEntity<LoadsResponse>(new LoadsResponse("Fail", "Load data not found..!!", null, null), HttpStatus.BAD_REQUEST);
		
	}
	
	//for updating the load data
	@PutMapping("/updateLoad")
	public ResponseEntity<LoadsResponse> updateLoad(@RequestBody LoadsPojo loadsPojo){
		LoadsPojo pojo=service.updateLoadData(loadsPojo);
		if(pojo != null) {
			return new ResponseEntity<LoadsResponse>(new LoadsResponse("Ok", "Load data updated successfully..!!", pojo, null),HttpStatus.ACCEPTED); 
		}
		   return new ResponseEntity<LoadsResponse>(new LoadsResponse("Fail", "Load data not updated", null, null), HttpStatus.BAD_REQUEST);
	} 
	//for deleting the load
	@DeleteMapping("/load/{loadId}")
	public String deleteLoad(@PathVariable long loadId) {
		return service.deleteLoad(loadId);
	}
	

}
