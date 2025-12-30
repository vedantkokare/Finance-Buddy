package com.expense.BudgetBee_Boot.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expensetbl")
public class Expense_Entities {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String category;

	private int amount;
    
    private LocalDate date;

    @Column(name = "credit_amount")
    private int creditAmount;   // ✅ JPQL: e.creditAmount

    @Column(name = "debit_amount")
    private int debitAmount;    // ✅ JPQL: e.debitAmount

    @Column(name = "pay_type")
    private String payType;     // values: "Credit" / "Debit"

    @Column(name = "pay_mode")
    private String payMode;

    private String description;

    @Column(name = "usermail")
    private String username;    // ✅ JPQL: e.username

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}

	public int getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(int debitAmount) {
		this.debitAmount = debitAmount;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
		
	
    public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Expense_Entities(String category, int amount, LocalDate date, String payType, String payMode,
			String description) {
		super();
		this.category = category;
		this.amount = amount;
		this.date = date;
		this.payType = payType;
		this.payMode = payMode;
		this.description = description;
	}

	public Expense_Entities() {
		super();
	}

	public Expense_Entities(Integer id, String category, LocalDate date, int creditAmount, int debitAmount,
			String payType, String payMode, String description) {
		super();
		this.id = id;
		this.category = category;
		this.date = date;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.payType = payType;
		this.payMode = payMode;
		this.description = description;
	}

	public Expense_Entities(Integer id, String category, int amount, LocalDate date, int creditAmount, int debitAmount,
			String payType, String payMode, String description, String username) {
		super();
		this.id = id;
		this.category = category;
		this.amount = amount;
		this.date = date;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.payType = payType;
		this.payMode = payMode;
		this.description = description;
		this.username = username;
	}

	public Expense_Entities(Integer id) {
		super();
		this.id = id;
	}

	public Expense_Entities(String username) {
		super();
		this.username = username;
	}

}