package com.estudos.desafio_dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.desafio_dio.domain.model.PaymentType;
import com.estudos.desafio_dio.domain.repository.PaymentTypeRepository;
import com.estudos.desafio_dio.dto.DeleteItemPaymentDTO;
import com.estudos.desafio_dio.service.PaymentTypeService;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    private final PaymentTypeRepository paymentTypeRepository;

    @Autowired
    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public List<PaymentType> findAll() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType findById(Long id) {
        return paymentTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentType não encontrado"));
    }

    @Override
    public PaymentType create(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public PaymentType update(PaymentType updatedPaymentType, Long id) {
        PaymentType paymentType = paymentTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PaymentType não encontrado"));

        // Atualize os campos necessários
        paymentType.setName(updatedPaymentType.getName());
        paymentType.setColor(updatedPaymentType.getColor());
        // Adicione outras atualizações conforme necessário

        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public DeleteItemPaymentDTO delete(Long id) {
        try {
            // Verifica se existe antes de tentar deletar
            PaymentType paymentTypeToDelete = paymentTypeRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("PaymentType não encontrado."));

            // Deleta do repositório
            paymentTypeRepository.delete(paymentTypeToDelete);

            // Mensagem de sucesso
            String messageSuccess = "PaymentType deletado com sucesso";

            // Retorna o DTO de sucesso
            return new DeleteItemPaymentDTO(paymentTypeToDelete.getId(), messageSuccess);

        } catch (Exception e) {
            // Em caso de erro, retorna o DTO de erro
            return new DeleteItemPaymentDTO(e.getMessage());
        }
    }
}
