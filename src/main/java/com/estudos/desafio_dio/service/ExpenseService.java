package com.estudos.desafio_dio.service;

import java.util.List;

import com.estudos.desafio_dio.domain.model.Expense;
import com.estudos.desafio_dio.dto.DeleteExpenseDTO;

public interface ExpenseService {
    Expense findById(Long id);

    List<Expense> findAll();

    Expense create(Expense expenseToCreate);

    Expense update(Expense expenseToUpdate, Long id);

    DeleteExpenseDTO delete(Long id);
}
