package com.expense.BudgetBee_Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.BudgetBee_Boot.Repository.LoginRepo;
import com.expense.BudgetBee_Boot.entities.Login_Entities;

@Service
public class Login_Service {

    @Autowired
    private LoginRepo loginRepo;

    // REGISTER
    public Login_Entities register(Login_Entities log_entity) {
        return loginRepo.save(log_entity);
    }

    // LOGIN
    public Login_Entities login(String email, String pwd) {
        return loginRepo.findByEmailAndPwd(email, pwd);
    }
}
