package com.sb.foodsystem.service;

import com.sb.foodsystem.model.OrderDTO;

public interface OrderService {

	OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long orderId);

    OrderDTO updateOrder(Long orderId, OrderDTO orderDTO);

    String deleteOrder(Long orderId);
}