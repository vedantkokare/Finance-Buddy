package com.expense.BudgetBee_Boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.BudgetBee_Boot.entities.Login_Entities;

public interface LoginRepo extends JpaRepository<Login_Entities, Integer> {

	Login_Entities findByEmailAndPwd(String email, String pwd);

}
