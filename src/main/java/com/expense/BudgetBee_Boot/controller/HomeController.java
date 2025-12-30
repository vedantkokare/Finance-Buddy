																																											package com.expense.BudgetBee_Boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expense.BudgetBee_Boot.entities.Expense_Entities;
import com.expense.BudgetBee_Boot.service.ExpenseService;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

	@Autowired
	ExpenseService es;

	@RequestMapping("/")
	public String starterPages() {
		return "Login";
	}

	@RequestMapping("/loginpage")
	public String loginPage(HttpSession hs) {
		hs.invalidate();
		return "Login";
	}

	@RequestMapping("/register_page")
	public String registerPage() {
		return "Register";
	}

	@RequestMapping("/dashboard-page")
	public String dashboardPage(HttpSession hs, Model m) {
		String username = (String) hs.getAttribute("log-name");
		
		List<Expense_Entities> list = es.getAll(username);
		m.addAttribute("list", list);
		
		m.addAttribute("loggedIn", username);
		return "dashboard";

	}

	@RequestMapping("/transactions")
	public String TransactionPage(HttpSession hs, Model m) {
		String username = (String) hs.getAttribute("log-name");
		List<Expense_Entities> list = es.getAll(username);
		m.addAttribute("list", list);
		m.addAttribute("loggedIn", username);
		return "Transactions";
	}

	@RequestMapping("/account-settings")
	public String account_setting() {
		return "UnderConstruction";
	}

}
