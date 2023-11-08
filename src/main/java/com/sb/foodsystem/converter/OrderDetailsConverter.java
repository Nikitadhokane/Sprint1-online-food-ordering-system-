package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.OrderDetails;
import com.sb.foodsystem.model.OrderDetailsDTO;

@Component
public class OrderDetailsConverter {

    public OrderDetailsDTO entityToDto(OrderDetails orderDetails) {
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
        orderDetailsDTO.setOrderDetails_Id(orderDetails.getOrderDetailsId());
        orderDetailsDTO.setOrder(orderDetails.getOrder());
        orderDetailsDTO.setMenu(orderDetails.getMenu());
        orderDetailsDTO.setAmount(orderDetails.getAmount());
        orderDetailsDTO.setTotalAmount(orderDetails.getTotalAmount());
        orderDetailsDTO.setQuantity(orderDetails.getQuantity());
        return orderDetailsDTO;
    }

    public OrderDetails dtoToEntity(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderDetailsId(orderDetailsDTO.getOrderDetails_Id());
        orderDetails.setOrder(orderDetailsDTO.getOrder());
        orderDetails.setMenu(orderDetailsDTO.getMenu());
        orderDetails.setAmount(orderDetailsDTO.getAmount());
        orderDetails.setTotalAmount(orderDetailsDTO.getTotalAmount());
        orderDetails.setQuantity(orderDetailsDTO.getQuantity());
        return orderDetails;
    }
}