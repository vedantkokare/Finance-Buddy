package com.expense.BudgetBee_Boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.expense.BudgetBee_Boot.entities.Expense_Entities;
import com.expense.BudgetBee_Boot.entities.Login_Entities;
import com.expense.BudgetBee_Boot.service.ExpenseService;
import com.expense.BudgetBee_Boot.service.Login_Service;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private Login_Service log_service;

    @Autowired
    private ExpenseService expenseService;

    // REGISTER
    @PostMapping("/register")
    public String register(Model m, @ModelAttribute Login_Entities log_entity) {

        Login_Entities savedUser = log_service.register(log_entity);

        if (savedUser != null && savedUser.getId() != 0) {
            m.addAttribute("successMsg", "Registration Successful");
            return "Login";
        } else {
            m.addAttribute("errorMsg", "Registration Failed");
            return "Register";
        }
    }

    // LOGIN
    @PostMapping("/login")
    public String login(Model m,
                        @ModelAttribute Login_Entities log_entity,
                        HttpSession session) {

        Login_Entities user = log_service.login(log_entity.getEmail(), log_entity.getPwd());

        if (user != null) {

            session.setAttribute("log-name", user.getEmail());
            String username = user.getEmail();

            m.addAttribute("loggedIn", username);

            int totalDebit = expenseService.totalDebit(username);
            m.addAttribute("totalDebit", totalDebit);

            int totalCredit = expenseService.totalCredit(username);
            m.addAttribute("totalCredit", totalCredit);

            int getTotalAmount = expenseService.getTotalAmount(username);
            m.addAttribute("getTotalAmount", getTotalAmount);

            List<Expense_Entities> list = expenseService.getAll(username);
            m.addAttribute("list", list);

            return "dashboard";
        } else {
            m.addAttribute("errorLogin", "Invalid Login Credentials");
            return "Login";
        }
    }
}
