package com.estudos.desafio_dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.desafio_dio.domain.model.PaymentDone;

@Repository
public interface PaymentDoneRepository extends JpaRepository<PaymentDone, Long> {
}
