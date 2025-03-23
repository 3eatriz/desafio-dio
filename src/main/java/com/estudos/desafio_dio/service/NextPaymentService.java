package com.estudos.desafio_dio.service;

import java.util.List;

import com.estudos.desafio_dio.domain.model.Expense;
import com.estudos.desafio_dio.domain.model.NextPayment;
import com.estudos.desafio_dio.dto.DeleteItemPaymentDTO;

public interface NextPaymentService {
    List<NextPayment> findAll();

    NextPayment findById(Long id);

    NextPayment create(NextPayment nextPayment);

    NextPayment update(NextPayment nextPayment, Long id);

    DeleteItemPaymentDTO delete(Long id);
}
