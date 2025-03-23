package com.estudos.desafio_dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.desafio_dio.domain.model.NextPayment;
import com.estudos.desafio_dio.domain.repository.NextPaymentRepository;
import com.estudos.desafio_dio.dto.DeleteItemPaymentDTO;
import com.estudos.desafio_dio.service.NextPaymentService;

@Service
public class NextPaymentServiceImpl implements NextPaymentService {

    private final NextPaymentRepository nextPaymentRepository;

    @Autowired
    public NextPaymentServiceImpl(NextPaymentRepository nextPaymentRepository) {
        this.nextPaymentRepository = nextPaymentRepository;
    }

    @Override
    public List<NextPayment> findAll() {
        return nextPaymentRepository.findAll();
    }

    @Override
    public NextPayment findById(Long id) {
        return nextPaymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NextPayment não encontrado"));
    }

    @Override
    public NextPayment create(NextPayment nextPayment) {
        return nextPaymentRepository.save(nextPayment);
    }

    @Override
    public NextPayment update(NextPayment updatedNextPayment, Long id) {
        NextPayment nextPayment = nextPaymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NextPayment não encontrado"));

        // Aqui você pode atualizar os campos necessários
        nextPayment.setName(updatedNextPayment.getName());
        nextPayment.setColor(updatedNextPayment.getColor());
        // Adicione outras atualizações conforme necessário

        return nextPaymentRepository.save(nextPayment);
    }

    @Override
    public DeleteItemPaymentDTO delete(Long id) {
        try {
            // Verifica se existe antes de tentar deletar
            NextPayment nextPaymentToDelete = nextPaymentRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("NextPayment não encontrado."));

            // Deleta do repositório
            nextPaymentRepository.delete(nextPaymentToDelete);

            // Mensagem de sucesso
            String messageSuccess = "NextPayment deletado com sucesso";

            // Retorna o DTO de sucesso
            return new DeleteItemPaymentDTO(nextPaymentToDelete.getId(), messageSuccess);

        } catch (Exception e) {
            // Em caso de erro, retorna o DTO de erro
            return new DeleteItemPaymentDTO(e.getMessage());
        }
    }
}
