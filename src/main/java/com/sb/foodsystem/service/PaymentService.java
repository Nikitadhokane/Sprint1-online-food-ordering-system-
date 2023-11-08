package com.sb.foodsystem.service;

import com.sb.foodsystem.model.PaymentDTO;

public interface PaymentService {

    PaymentDTO createPayment(PaymentDTO paymentDTO);

    PaymentDTO getPaymentById(Long id);

    PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO);

    String deletePayment(Long id);
}