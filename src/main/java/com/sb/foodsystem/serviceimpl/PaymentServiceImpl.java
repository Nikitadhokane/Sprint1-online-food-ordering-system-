package com.sb.foodsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.PaymentConverter;
import com.sb.foodsystem.dao.PaymentRepository;
import com.sb.foodsystem.entity.Payment;
import com.sb.foodsystem.model.PaymentDTO;
import com.sb.foodsystem.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	  @Autowired
	  private final PaymentRepository paymentRepository;
	
	  @Autowired
	  private final PaymentConverter paymentConverter;

  
	  public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentConverter paymentConverter) 
	  {
        this.paymentRepository = paymentRepository;
        this.paymentConverter = paymentConverter;
    }

	  @Override
	  public PaymentDTO createPayment(PaymentDTO paymentDTO)
	  {
        Payment payment = paymentConverter.dtoToEntity(paymentDTO);
        payment = paymentRepository.save(payment);
        return paymentConverter.entityToDto(payment);
	  }

	  @Override
	  public PaymentDTO getPaymentById(Long id)
	  {
        Payment payment = paymentRepository.findById(id).orElse(null);
        return paymentConverter.entityToDto(payment);
	  }

	  @Override
	  public PaymentDTO updatePayment(Long id, PaymentDTO paymentDTO)
	  {
        Payment payment = paymentConverter.dtoToEntity(paymentDTO);
        payment.setId(id); // Assuming id is part of the PaymentDTO
        payment = paymentRepository.save(payment);
        return paymentConverter.entityToDto(payment);
	  }

	  @Override
	  public String deletePayment(Long id) 
	  {
        paymentRepository.deleteById(id);
        return "Payment with ID " + id + " has been deleted successfully.";
	  }
}
