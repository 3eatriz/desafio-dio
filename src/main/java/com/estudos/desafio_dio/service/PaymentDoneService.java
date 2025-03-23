package com.estudos.desafio_dio.service;

import java.util.List;

import com.estudos.desafio_dio.domain.model.PaymentDone;
import com.estudos.desafio_dio.domain.model.PaymentDone;
import com.estudos.desafio_dio.dto.DeleteItemPaymentDTO;

public interface PaymentDoneService {
    List<PaymentDone> findAll();

    PaymentDone findById(Long id);

    PaymentDone create(PaymentDone paymentDone);

    PaymentDone update(PaymentDone paymentDone, Long id);

    DeleteItemPaymentDTO delete(Long id);
}
