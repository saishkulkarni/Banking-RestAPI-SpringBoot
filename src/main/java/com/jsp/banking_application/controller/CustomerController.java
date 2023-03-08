package com.jsp.banking_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.banking_application.dto.Customer;
import com.jsp.banking_application.dto.Login;
import com.jsp.banking_application.exception.MyException;
import com.jsp.banking_application.helper.ResponseStructure;
import com.jsp.banking_application.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("add")
	public ResponseStructure<Customer> save(@RequestBody Customer customer) throws MyException {
		return service.save(customer);
	}
	
	@PutMapping("otp/{custid}/{otp}")
	public ResponseStructure<Customer> otpVerify(@PathVariable int custid,@PathVariable int otp) throws MyException
	{
		return service.verify(custid,otp);
	}
	
	@PostMapping("login")
	public ResponseStructure<Customer> login(@RequestBody Login login) throws MyException
	{
		return service.login(login);
	}
	
	@PostMapping("account/{cust_id}/{type}")
	public ResponseStructure<Customer> createAccount(@PathVariable int cust_id,@PathVariable String type) throws MyException
	{
		return service.createAccount(cust_id,type);
	}
	
}
