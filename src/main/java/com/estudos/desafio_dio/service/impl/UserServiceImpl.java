package com.estudos.desafio_dio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.estudos.desafio_dio.domain.model.User;
import com.estudos.desafio_dio.domain.repository.UserRepository;
import com.estudos.desafio_dio.dto.DeleteUserDTO;
import com.estudos.desafio_dio.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User userToCreate) {
        List<User> users = userRepository.findAll();
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("Esse usuário já existe.");
        }
        users.forEach(user -> {
            if (userToCreate.getName() == user.getName()) {
                throw new IllegalArgumentException("Esse nome de usuário já existe, escolha outro.");
            }
        });

        return this.userRepository.save(userToCreate);
    }

    @Override
    public User update(User userToUpdate, Long id) {
        // Verifica se o usuário existe antes de atualizar
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        // Verifica se o nome de usuário já existe para outro usuário
        boolean nameExists = userRepository.findAll().stream()
                .anyMatch(user -> !user.getId().equals(id) && user.getName().equals(userToUpdate.getName()));

        if (nameExists) {
            throw new IllegalArgumentException("Esse nome de usuário já existe, escolha outro.");
        }

        // Mantém os dados existentes que não foram enviados na atualização
        existingUser.setName(userToUpdate.getName() != null ? userToUpdate.getName() : existingUser.getName());
        existingUser.setAvatar(userToUpdate.getAvatar() != null ? userToUpdate.getAvatar() : existingUser.getAvatar());
        existingUser.setBalance(userToUpdate.getBalance() != null ? userToUpdate.getBalance() : existingUser.getBalance());
        existingUser.setExpenses(userToUpdate.getExpenses() != null ? userToUpdate.getExpenses() : existingUser.getExpenses());

        return userRepository.save(existingUser);
    }

   @Override
    public DeleteUserDTO delete(Long id) {
        try {
            // Verifica se o usuário existe antes de tentar deletar
            User userToDelete = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

            // Deleta a despesa do repositório
            userRepository.delete(userToDelete);

            // Retorna o DTO de sucesso
            return new DeleteUserDTO(userToDelete);

        } catch (Exception e) {
            // Em caso de erro, retorna o DTO de erro
            return new DeleteUserDTO(e.getMessage());
        }
    }

}
