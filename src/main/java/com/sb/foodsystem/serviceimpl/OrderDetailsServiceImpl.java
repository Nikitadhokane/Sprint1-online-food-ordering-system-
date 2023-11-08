package com.sb.foodsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.OrderDetailsConverter;
import com.sb.foodsystem.dao.OrderDetailsRepository;
import com.sb.foodsystem.entity.OrderDetails;
import com.sb.foodsystem.model.OrderDetailsDTO;
import com.sb.foodsystem.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
    private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
    private OrderDetailsConverter orderDetailsConverter;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, OrderDetailsConverter orderDetailsConverter) 
    {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderDetailsConverter = orderDetailsConverter;
    }
    
    OrderDetails orderDetails = new OrderDetails();
   
    public OrderDetails saveOrderDetails(OrderDetails orderDetails) 
    {
    	 orderDetails.getOrder();
        return orderDetailsRepository.save(orderDetails);
    }
   
    @Override
    public OrderDetailsDTO createOrderDetails(OrderDetailsDTO orderDetailsDTO) 
    {
        OrderDetails orderDetails = orderDetailsConverter.dtoToEntity(orderDetailsDTO);
        orderDetails = orderDetailsRepository.save(orderDetails);
        return orderDetailsConverter.entityToDto(orderDetails);
    }

    @Override
    public OrderDetailsDTO getOrderDetailsById(Long id) 
    {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElse(null);
        return orderDetailsConverter.entityToDto(orderDetails);
    }

    @Override
    public OrderDetailsDTO updateOrderDetails(Long id, OrderDetailsDTO orderDetailsDTO)
    {
        OrderDetails orderDetails = orderDetailsConverter.dtoToEntity(orderDetailsDTO);
        orderDetails.setOrderDetailsId(id);// Assuming orderDetailsId is part of the OrderDetailsDTO
        orderDetails = orderDetailsRepository.save(orderDetails);
        return orderDetailsConverter.entityToDto(orderDetails);
    }

    @Override
    public String deleteOrderDetails(Long id) 
    {
        orderDetailsRepository.deleteById(id);
        return "OrderDetails with ID " + id + " has been deleted successfully.";
    }
}