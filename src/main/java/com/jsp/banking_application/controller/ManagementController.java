package com.jsp.banking_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.banking_application.dto.BankAccount;
import com.jsp.banking_application.dto.Management;
import com.jsp.banking_application.exception.MyException;
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
	
	@PostMapping("login")
	public ResponseStructure<Management> login(@RequestBody Management management) throws MyException
	{
		return service.login(management);
	}
	
	@GetMapping("accounts")
	public ResponseStructure<List<BankAccount>> fetchAllAccounts() throws MyException
	{
		return service.fetchAllAccounts();
	}
	
	@PutMapping("accountchange/{acno}")
	public ResponseStructure<BankAccount> changeStatus(@PathVariable long acno)
	{
		return service.changeStatus(acno);
	}
}
