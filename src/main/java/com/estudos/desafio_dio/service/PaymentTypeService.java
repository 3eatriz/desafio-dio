package com.estudos.desafio_dio.service;

import java.util.List;

import com.estudos.desafio_dio.domain.model.PaymentType;
import com.estudos.desafio_dio.dto.DeleteItemPaymentDTO;

public interface PaymentTypeService {
    List<PaymentType> findAll();

    PaymentType findById(Long id);

    PaymentType create(PaymentType paymentType);

    PaymentType update(PaymentType paymentType, Long id);

    DeleteItemPaymentDTO delete(Long id);
}
