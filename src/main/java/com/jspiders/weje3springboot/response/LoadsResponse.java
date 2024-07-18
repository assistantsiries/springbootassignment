package com.jspiders.weje3springboot.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.weje3springboot.pojo.LoadsPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoadsResponse {
	
	private String status;
	private String msg;
	private LoadsPojo data;
	private List<LoadsPojo> list;

}
