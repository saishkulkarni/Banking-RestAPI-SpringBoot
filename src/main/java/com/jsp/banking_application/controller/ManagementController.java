package com.jsp.banking_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.banking_application.dto.Management;
import com.jsp.banking_application.helper.ResponseStructure;
import com.jsp.banking_application.service.ManagementService;

@RestController
@RequestMapping("management")
public class ManagementController {

	@Autowired
	ManagementService service;
	
	@PostMapping("add")
	public ResponseStructure<Management> save(@RequestBody Management management)
	{
		return service.save(management);
	}
}
