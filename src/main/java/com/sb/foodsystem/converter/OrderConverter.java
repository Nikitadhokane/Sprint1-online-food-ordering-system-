package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.Order;
import com.sb.foodsystem.model.OrderDTO;

@Component
public class OrderConverter {

    public OrderDTO entityToDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setUser(order.getUser());
        orderDTO.setRestaurant(order.getRestaurant());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotalAmount(order.getTotal_amount());
        orderDTO.setUserId(order.getUserId());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;
    }

    public Order dtoToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setUser(orderDTO.getUser());
        order.setRestaurant(orderDTO.getRestaurant());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotal_amount(orderDTO.getTotalAmount());
        order.setUserId(orderDTO.getUserId());
        order.setStatus(orderDTO.getStatus());
        return order;
    }
}