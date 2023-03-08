package com.jsp.banking_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.banking_application.dto.Management;
import com.jsp.banking_application.helper.ResponseStructure;
import com.jsp.banking_application.repository.ManagementRepository;

@Service
public class ManagementService {

	@Autowired
	ManagementRepository repository;
	
	public ResponseStructure<Management> save(Management management)
	{
		ResponseStructure<Management> structure=new ResponseStructure();
		structure.setCode(HttpStatus.CREATED.value());
		structure.setMessage("Data Added Successfully");
		structure.setData(repository.save(management));
		return structure;
	}
}
