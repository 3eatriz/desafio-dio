package com.estudos.desafio_dio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.estudos.desafio_dio.domain.model.Expense;
import com.estudos.desafio_dio.domain.repository.ExpenseRepository;
import com.estudos.desafio_dio.dto.DeleteExpenseDTO;
import com.estudos.desafio_dio.service.ExpenseService;

public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense findById(Long id) {
        return expenseRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense create(Expense expenseToCreate) {
        // Verifica se já existe um ID e se ele já está cadastrado
        if (expenseToCreate.getId() != null && expenseRepository.existsById(expenseToCreate.getId())) {
            throw new IllegalArgumentException("Essa despesa já existe.");
        }

        // Verifica se os atributos obrigatórios estão nulos
        if (expenseToCreate.getExpenseName() == null ||
                expenseToCreate.getNextPayment() == null ||
                expenseToCreate.getPaymentType() == null ||
                expenseToCreate.getPaymentDone() == null ||
                expenseToCreate.getValue() == null ||
                expenseToCreate.getCurrentInstallment() == null ||
                expenseToCreate.getTotalInstallments() == null ||
                expenseToCreate.getTotalValue() == null) {

            throw new IllegalArgumentException("Campos obrigatórios não podem ser nulos.");
        }

        return expenseRepository.save(expenseToCreate);
    }

    @Override
    public Expense update(Expense expenseToUpdate, Long id) {
        // Verifica se a despesa existe antes de atualizar
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Despesa não encontrada para o ID: " + id));

        // Verifica se os atributos obrigatórios estão nulos
        if (expenseToUpdate.getExpenseName() == null ||
                expenseToUpdate.getNextPayment() == null ||
                expenseToUpdate.getPaymentType() == null ||
                expenseToUpdate.getPaymentDone() == null ||
                expenseToUpdate.getValue() == null ||
                expenseToUpdate.getCurrentInstallment() == null ||
                expenseToUpdate.getTotalInstallments() == null ||
                expenseToUpdate.getTotalValue() == null) {

            throw new IllegalArgumentException("Campos obrigatórios não podem ser nulos.");
        }

        // Atualiza os dados da despesa existente
        existingExpense.setExpenseName(expenseToUpdate.getExpenseName());
        existingExpense.setNextPayment(expenseToUpdate.getNextPayment());
        existingExpense.setPaymentType(expenseToUpdate.getPaymentType());
        existingExpense.setPaymentDone(expenseToUpdate.getPaymentDone());
        existingExpense.setValue(expenseToUpdate.getValue());
        existingExpense.setCurrentInstallment(expenseToUpdate.getCurrentInstallment());
        existingExpense.setTotalInstallments(expenseToUpdate.getTotalInstallments());
        existingExpense.setTotalValue(expenseToUpdate.getTotalValue());

        // O campo "notes" pode ser nulo, então pode ser atualizado sem validação
        existingExpense.setNotes(expenseToUpdate.getNotes());

        return expenseRepository.save(existingExpense);
    }

    @Override
    public DeleteExpenseDTO delete(Long id) {
        try {
            // Verifica se a despesa existe antes de tentar deletar
            Expense expenseToDelete = expenseRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Despesa não encontrada."));

            // Deleta a despesa do repositório
            expenseRepository.delete(expenseToDelete);

            // Retorna o DTO de sucesso
            return new DeleteExpenseDTO(expenseToDelete);

        } catch (Exception e) {
            // Em caso de erro, retorna o DTO de erro
            return new DeleteExpenseDTO(e.getMessage());
        }
    }
}
