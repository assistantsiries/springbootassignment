package com.jspiders.weje3springboot.pojo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;


@Data
@Entity
public class LoadsPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loadId;
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private int weight;
	private String comment;
	private String shipperId;
	private Date date;
	
	
	
	//@JsonManagedReference
	//@OneToMany(mappedBy = "person", cascade= {CascadeType.ALL})
	//private List<Order> orders;

}
