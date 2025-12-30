package com.expense.BudgetBee_Boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.BudgetBee_Boot.Repository.ExpenseRepo;
import com.expense.BudgetBee_Boot.entities.Expense_Entities;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    // ADD EXPENSE
    public void add(Expense_Entities e, String username) {
        e.setUsername(username); 
        expenseRepo.save(e);
    }

    // UPDATE EXPENSE
    public void updateExpense(Expense_Entities e, String username) {
    	e.setUsername(username); 
        expenseRepo.save(e);
    }

    // DELETE
    public void deleteExpense(int id) {
        expenseRepo.deleteById(id);
    }

    // GET ALL BY USER
    public List<Expense_Entities> getAll(String username) {
        return expenseRepo.findByUsername(username);
    }

    // TOTAL DEBIT
    public int totalDebit(String username) {
        return expenseRepo.totalDebit(username);
    }

    // TOTAL CREDIT
    public int totalCredit(String username) {
        return expenseRepo.totalCredit(username);
    }

    // FINAL BALANCE
    public int getTotalAmount(String username) {
        return totalCredit(username) - totalDebit(username);
    }

    // GET BY ID
    public Expense_Entities getById(int id) {
        return expenseRepo.findById(id).orElse(null);
    }
}
