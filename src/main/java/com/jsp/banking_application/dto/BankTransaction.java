package com.jsp.banking_application.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Component
public class BankTransaction
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
LocalDateTime dateTime;
double deposit;
double withdraw;
double balance;
}
