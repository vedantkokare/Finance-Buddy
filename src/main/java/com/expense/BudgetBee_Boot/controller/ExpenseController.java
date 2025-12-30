package com.expense.BudgetBee_Boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expense.BudgetBee_Boot.entities.Expense_Entities;
import com.expense.BudgetBee_Boot.service.ExpenseService;

import jakarta.servlet.http.HttpSession;	


@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService es;
	
	@GetMapping("/dashboard-page")
	public String dashboard(Model m, HttpSession hs) {

	    String username = (String) hs.getAttribute("log-name");

	    // totals
	    int totalDebit = es.totalDebit(username);
	    int totalCredit = es.totalCredit(username);
	    int totalAmount = es.getTotalAmount(username);

	    // list
	    List<Expense_Entities> list = es.getAll(username);

	    m.addAttribute("totalDebit", totalDebit);
	    m.addAttribute("totalCredit", totalCredit);
	    m.addAttribute("getTotalAmount", totalAmount);
	    m.addAttribute("list", list);

	    return "dashboard";
	}

	
	@RequestMapping("/insert")
	public String add(
	        HttpSession hs,
	        @ModelAttribute Expense_Entities e,
	        @RequestParam("amount") int amount
	) {
	    String username = (String) hs.getAttribute("log-name");

	    if ("credit".equalsIgnoreCase(e.getPayType())) {
	        e.setCreditAmount(amount);
	        e.setDebitAmount(0);
	    } else {
	        e.setDebitAmount(amount);
	        e.setCreditAmount(0);
	    }

	    es.add(e, username);

	    return "redirect:/dashboard-page";
	}

	
	@RequestMapping("/edit")
	public String updateExpense(
	        @ModelAttribute Expense_Entities e,
	        @RequestParam("amount") int amount,
	        HttpSession hs
	) {
	    String username = (String) hs.getAttribute("log-name");

	    if ("credit".equalsIgnoreCase(e.getPayType())) {
	        e.setCreditAmount(amount);
	        e.setDebitAmount(0);
	    } else {
	        e.setDebitAmount(amount);
	        e.setCreditAmount(0);
	    }

	    es.updateExpense(e, username);

	    return "redirect:/dashboard-page";
	}

	
	@GetMapping("/deleteExpense")
	public String deleteExpense(@RequestParam("id") int id) {
	    es.deleteExpense(id);
	    return "redirect:/dashboard-page";
	}
	
	@GetMapping("/editformid")
	public String getById(@RequestParam("id") int id,Model m) {
		
		Expense_Entities ee = es.getById(id);
		m.addAttribute("id",ee.getId());
		m.addAttribute("category",ee.getCategory());
		m.addAttribute("date",ee.getDate());
		m.addAttribute("amount",ee.getAmount());
		m.addAttribute("pay_mode",ee.getPayMode());
		m.addAttribute("pay_type",ee.getPayType());
		m.addAttribute("description",ee.getDescription());
		
		return "dashboard";
		
	}
	
	public String getAll(Model m,HttpSession hs	) {
		
		String username =(String) hs.getAttribute("log-name");
		List<Expense_Entities> list =es.getAll(username);
		  m.addAttribute("list", list);
		return "redirect:/dashboard-page";
		
	}
}