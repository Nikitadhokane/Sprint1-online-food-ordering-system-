package com.sb.foodsystem.repository;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Time;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.PaymentRepository;
import com.sb.foodsystem.entity.Payment;

@SpringBootTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void testSavePayment() {
        // Create a new Payment
        Payment payment = new Payment();
        payment.setAmount(100);
        payment.setTime(new Time(new Date().getTime()));

        // Save the payment
        Payment savedPayment = paymentRepository.save(payment);

        // Check that the saved payment has an ID
        assertNotNull(savedPayment.getId());
    }

    @Test
    public void testFindPaymentById() {
        // Create a new Payment
        Payment payment = new Payment();
        payment.setAmount(100);
        payment.setTime(new Time(new Date().getTime()));

        // Save the payment
        Payment savedPayment = paymentRepository.save(payment);

        // Find the payment by its ID
        Payment foundPayment = paymentRepository.findPaymentById(savedPayment.getId());

        // Assert that the found payment is not null
        assertNotNull(foundPayment);
    }

    @Test
    public void testUpdatePayment() {
        // Create a new Payment
        Payment payment = new Payment();
        payment.setAmount(100);
        payment.setTime(new Time(new Date().getTime()));

        // Save the payment
        Payment savedPayment = paymentRepository.save(payment);

        // Update the payment
        savedPayment.setAmount(200);
        Payment updatedPayment = paymentRepository.save(savedPayment);

        // Assert that the updated payment has the new amount
        assertEquals(200, updatedPayment.getAmount());
    }

    @Test
    public void testDeletePayment() {
        // Create and save a new Payment
        Payment payment = new Payment();
        payment.setAmount(100);
        payment.setTime(new Time(new Date().getTime()));
        Payment savedPayment = paymentRepository.save(payment);

        // Delete the payment
        paymentRepository.deleteById(savedPayment.getId());

        // Attempt to retrieve the payment after deletion
        Payment deletedPayment = paymentRepository.findPaymentById(savedPayment.getId());

        // Assert that the deleted payment is null
        assertNull(deletedPayment);
    }
}


