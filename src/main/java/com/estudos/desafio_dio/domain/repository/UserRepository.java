package com.estudos.desafio_dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.desafio_dio.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
