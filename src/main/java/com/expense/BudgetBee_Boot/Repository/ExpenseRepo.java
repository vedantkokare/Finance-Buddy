package com.expense.BudgetBee_Boot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expense.BudgetBee_Boot.entities.Expense_Entities;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense_Entities, Integer> {

	List<Expense_Entities> findByUsername(String username);

	  // TOTAL CREDIT
    @Query("""
        SELECT COALESCE(SUM(e.creditAmount), 0)
        FROM Expense_Entities e
        WHERE e.username = :username
    """)
    Integer totalCredit(@Param("username") String username);

    // TOTAL DEBIT
    @Query("""
        SELECT COALESCE(SUM(e.debitAmount), 0)
        FROM Expense_Entities e
        WHERE e.username = :username
    """)
    Integer totalDebit(@Param("username") String username);
}
