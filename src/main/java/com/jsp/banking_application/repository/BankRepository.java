package com.jsp.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.banking_application.dto.BankAccount;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Long>
{

}
