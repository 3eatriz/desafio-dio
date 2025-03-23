package com.estudos.desafio_dio.service;

import java.util.List;

import com.estudos.desafio_dio.domain.model.User;
import com.estudos.desafio_dio.dto.DeleteUserDTO;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    User create(User userToCreate);

    User update(User userToUpdate, Long id);

    DeleteUserDTO delete(Long id);
}