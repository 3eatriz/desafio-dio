package com.estudos.desafio_dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.desafio_dio.domain.model.PaymentDone;
import com.estudos.desafio_dio.domain.repository.PaymentDoneRepository;
import com.estudos.desafio_dio.dto.DeleteItemPaymentDTO;
import com.estudos.desafio_dio.service.PaymentDoneService;

@Service
public class PaymentDoneServiceImpl implements PaymentDoneService {

    private final PaymentDoneRepository paymentDoneRepository;

    @Autowired
    public PaymentDoneServiceImpl(PaymentDoneRepository paymentDoneRepository) {
        this.paymentDoneRepository = paymentDoneRepository;
    }

    @Override
    public List<PaymentDone> findAll() {
        return paymentDoneRepository.findAll();
    }

    @Override
    public PaymentDone findById(Long id) {
        return paymentDoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentDone não encontrado"));
    }

    @Override
    public PaymentDone create(PaymentDone paymentDone) {
        return paymentDoneRepository.save(paymentDone);
    }

    @Override
    public PaymentDone update(PaymentDone updatedPaymentDone, Long id) {
        PaymentDone paymentDone = paymentDoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentDone não encontrado"));

        // Atualize os campos necessários
        paymentDone.setName(updatedPaymentDone.getName());
        paymentDone.setColor(updatedPaymentDone.getColor());
        // Adicione outras atualizações conforme necessário

        return paymentDoneRepository.save(paymentDone);
    }

    @Override
    public DeleteItemPaymentDTO delete(Long id) {
        try {
            // Verifica se existe antes de tentar deletar
            PaymentDone paymentDoneToDelete = paymentDoneRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("PaymentDone não encontrado."));

            // Deleta do repositório
            paymentDoneRepository.delete(paymentDoneToDelete);

            // Mensagem de sucesso
            String messageSuccess = "PaymentDone deletado com sucesso";

            // Retorna o DTO de sucesso
            return new DeleteItemPaymentDTO(paymentDoneToDelete.getId(), messageSuccess);

        } catch (Exception e) {
            // Em caso de erro, retorna o DTO de erro
            return new DeleteItemPaymentDTO(e.getMessage());
        }
    }
}
