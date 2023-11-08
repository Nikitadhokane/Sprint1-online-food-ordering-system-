package com.sb.foodsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.foodsystem.converter.PaymentConverter;
import com.sb.foodsystem.model.PaymentDTO;
import com.sb.foodsystem.service.PaymentService;

@RestController
//@RequestMapping("/payments")
@RequestMapping("/api")
public class PaymentController {

	@Autowired
    private final PaymentService paymentService;
	
	@SuppressWarnings("unused")
	@Autowired
    private final PaymentConverter paymentConverter;

    public PaymentController(PaymentService paymentService, PaymentConverter paymentConverter) 
    {
        this.paymentService = paymentService;
        this.paymentConverter = paymentConverter;
    }

    @PostMapping("/payments")
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) 
    {
        PaymentDTO createdPayment = paymentService.createPayment(paymentDTO);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) 
    {
        PaymentDTO payment = paymentService.getPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO)
    {
        PaymentDTO updatedPayment = paymentService.updatePayment(id, paymentDTO);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }


    @DeleteMapping("/payments/{id}")
    public String deletePayment(@PathVariable Long id) 
    {
        return paymentService.deletePayment(id);
    }
}