package com.jsp.banking_application.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
@Component
public class BankAccount 
{
@Id
@SequenceGenerator(name = "acno",sequenceName = "acno",initialValue = 1002121111,allocationSize = 1)
@GeneratedValue(generator = "acno")
long number;
String type;
double banklimit;
double amount;
boolean status;
}
  