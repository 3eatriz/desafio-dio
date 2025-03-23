package com.estudos.desafio_dio.dto;

import com.estudos.desafio_dio.domain.model.Expense;

public class DeleteExpenseDTO {
    private Boolean error;
    private String message;
    private Long id;

    // Construtor para sucesso
    public DeleteExpenseDTO(Expense expense) {
        this.error = false; // Indica que não houve erro
        this.message = "Despesa deletada com sucesso"; // Mensagem de sucesso
        this.id = expense.getId(); // ID da despesa deletada
    }

    // Construtor para erro
    public DeleteExpenseDTO(String errorMessage) {
        this.error = true; // Indica que houve erro
        this.message = errorMessage; // Mensagem de erro
        this.id = null; // Não há ID no caso de erro
    }

    // Getters e Setters
    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
