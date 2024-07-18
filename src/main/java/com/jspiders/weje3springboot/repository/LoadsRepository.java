package com.jspiders.weje3springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.weje3springboot.pojo.LoadsPojo;

public interface LoadsRepository extends JpaRepository<LoadsPojo, Long>{

	List<LoadsPojo> findByShipperId(String shipperId);

	

}
