package com.estudos.desafio_dio.dto;

public class DeleteItemPaymentDTO {
    private boolean error;
    private String message;
    private Long id;

    // Construtor para sucesso
    public DeleteItemPaymentDTO(Long id, String message) {
        this.error = false;
        this.message = message;
        this.id = id;
    }

    // Construtor para erro
    public DeleteItemPaymentDTO(String errorMessage) {
        this.error = true; // Indica que houve erro
        this.message = errorMessage; // Mensagem de erro
        this.id = null; // Não há ID no caso de erro
    }

    // Getters e Setters
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
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
