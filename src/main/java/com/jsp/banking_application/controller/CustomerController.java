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
import com.jsp.banking_application.dto.BankTransaction;
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
	
	@GetMapping("accounts/{custid}")
	public ResponseStructure<List<BankAccount>> fetchAllTrue(@PathVariable int custid) throws MyException
	{
		return service.fetchAllTrue(custid);
	}
	
	@GetMapping("account/check/{acno}")
	public ResponseStructure<Double> checkBalance(@PathVariable long acno)
	{
		return service.checkBalance(acno);
	}
	
	@PutMapping("account/deposit/{acno}/{amount}")
	public ResponseStructure<BankAccount> deposit(@PathVariable long acno,@PathVariable double amount)
	{
		return service.deposit(acno,amount);
	}
	
	@PutMapping("account/withdraw/{acno}/{amount}")
	public ResponseStructure<BankAccount> withdraw(@PathVariable long acno,@PathVariable double amount) throws MyException
	{
		return service.withdraw(acno,amount);
	}
	
	@GetMapping("account/viewtransaction/{acno}")
	public ResponseStructure<List<BankTransaction>> viewTransaction(@PathVariable long acno) throws MyException
	{
		return service.viewtransaction(acno);
	}
	{
		
	}
}
