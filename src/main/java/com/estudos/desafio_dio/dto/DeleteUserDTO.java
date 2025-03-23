package com.estudos.desafio_dio.dto;

import com.estudos.desafio_dio.domain.model.User;

public class DeleteUserDTO {
    private Boolean error;
    private String message;
    private Long id;

    // Construtor para sucesso
    public DeleteUserDTO(User user) {
        this.error = false; // Indica que não houve erro
        this.message = "Usuário deletado com sucesso"; // Mensagem de sucesso
        this.id = user.getId(); // ID do usuário deletado
    }

    // Construtor para erro
    public DeleteUserDTO(String errorMessage) {
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