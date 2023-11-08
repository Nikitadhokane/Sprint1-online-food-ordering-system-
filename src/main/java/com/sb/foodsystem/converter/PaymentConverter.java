package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.Payment;
import com.sb.foodsystem.model.PaymentDTO;

@Component
public class PaymentConverter {

    public PaymentDTO entityToDto(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(payment.getId());
        paymentDTO.setOrder(payment.getOrder());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setTime(payment.getTime());
        return paymentDTO;
    }

    public Payment dtoToEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setId(paymentDTO.getId());
        payment.setOrder(paymentDTO.getOrder());
        payment.setAmount(paymentDTO.getAmount());
        payment.setTime(paymentDTO.getTime());
        return payment;
    }
}