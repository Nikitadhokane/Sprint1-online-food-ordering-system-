package com.sb.foodsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.OrderConverter;
import com.sb.foodsystem.dao.OrderRepository;
import com.sb.foodsystem.entity.Order;
import com.sb.foodsystem.model.OrderDTO;
import com.sb.foodsystem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
    private final OrderRepository orderRepository;
	
	@Autowired
    private final OrderConverter orderConverter;

    
    public OrderServiceImpl(OrderRepository orderRepository, OrderConverter orderConverter)
    {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }

    // Method to save the Order
    Order order = new Order();
    public Order saveOrder(Order order)
    {
        return orderRepository.save(order);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) 
    {
        Order order = orderConverter.dtoToEntity(orderDTO);
        order = orderRepository.save(order);
        return orderConverter.entityToDto(order);
    }

    @Override
    public OrderDTO getOrderById(Long orderId) 
    {
        Order order = orderRepository.findById(orderId).orElse(null);
        return orderConverter.entityToDto(order);
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) 
    {
        Order order = orderConverter.dtoToEntity(orderDTO);
        order.setOrderId(orderId); // Assuming id is part of the OrderDTO
        order = orderRepository.save(order);
        return orderConverter.entityToDto(order);
    }

    @Override
    public String deleteOrder(Long orderId)
    {
        orderRepository.deleteById(orderId);
        return "Order with ID " + orderId + " has been deleted successfully.";
    }
}