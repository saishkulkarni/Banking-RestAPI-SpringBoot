package com.jsp.banking_application.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.banking_application.dto.BankAccount;
import com.jsp.banking_application.dto.Customer;
import com.jsp.banking_application.dto.Login;
import com.jsp.banking_application.exception.MyException;
import com.jsp.banking_application.helper.MailVerification;
import com.jsp.banking_application.helper.ResponseStructure;
import com.jsp.banking_application.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	MailVerification mailVerification;
	
	@Autowired
	BankAccount account;
	
	public ResponseStructure<Customer> save(Customer customer) throws MyException {
		ResponseStructure<Customer> structure = new ResponseStructure();
		int age=Period.between(customer.getDob().toLocalDate(), LocalDate.now()).getYears();
		customer.setAge(age);
		if(age<18)
		{
		throw new MyException("You should be 18+ to create Account");
		}
		else{
			Random random=new Random();
			int otp=random.nextInt(100000, 999999);
			customer.setOtp(otp);
			
			mailVerification.sendMail(customer);
			
			structure.setMessage("Verification Mail sent");
			structure.setCode(HttpStatus.PROCESSING.value());
			structure.setData(repository.save(customer));
		}
		
		
		
		return structure;
	}

	public ResponseStructure<Customer> verify(int custid, int otp) throws MyException {
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		
		Optional<Customer> optional = repository.findById(custid);
		if(optional.isEmpty())
		{
			throw new MyException("Check Id and Try Again");
		}
		else {
			Customer customer=optional.get();
			if(customer.getOtp()==otp)
			{
				structure.setCode(HttpStatus.CREATED.value());
				structure.setMessage("Account Created Successfully");
				customer.setStatus(true);
				structure.setData(repository.save(customer));
			}
			else {
				throw new MyException("OTP MISSMATCH");
			}
		}
		
		
		return structure;
	}

	public ResponseStructure<Customer> login(Login login) throws MyException {
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
	
		Optional<Customer> optional = repository.findById(login.getId());
		if(optional.isEmpty())
		{
			throw new MyException("Invalid Customer Id ");
		}
		else {
			Customer customer =optional.get();
			if(customer.getPassword().equals(login.getPassword()))
			{
				if(customer.isStatus())
				{
					structure.setCode(HttpStatus.ACCEPTED.value());
					structure.setMessage("Login Success");
					structure.setData(customer);
				}
				else {
					throw new MyException("Verify your email first");
				}
			}
			else {
				throw new MyException("Invalid Password");
			}
		}
		return structure;
	}

	public ResponseStructure<Customer> createAccount(int cust_id, String type) throws MyException {
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		
		Optional<Customer> optional = repository.findById(cust_id);
		if(optional.isEmpty())
		{
			throw new MyException("Invalid Customer Id ");
		}
		else {
			Customer customer =optional.get();
			List<BankAccount> list=customer.getAccounts();
			
			boolean flag=true;
			for(BankAccount account:list)
			{
				if(account.getType().equals(type))
				{
					flag=false;
					break;
				}
			}
			
			if(!flag)
			{
				throw new MyException(type+" Account Already Exists");
			}
			else {
			account.setType(type);
			if(type.equals("savings"))
			{
				account.setBanklimit(5000);
			} 	
			else {
				account.setBanklimit(10000);
			}
			
			list.add(account);
			customer.setAccounts(list);
			}
			structure.setCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Account created wait for management to approve");
			structure.setData(repository.save(customer));
		}
		
		
		
		
		
		return structure;
		
	}
}
