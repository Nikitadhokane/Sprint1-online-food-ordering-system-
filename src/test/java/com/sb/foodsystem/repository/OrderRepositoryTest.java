package com.sb.foodsystem.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.OrderRepository;
import com.sb.foodsystem.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setTotal_amount(100);
        order.setStatus("Pending");

        Order savedOrder = orderRepository.save(order);
        assertNotNull(savedOrder.getOrderId());
    }

     @Test
    public void testSaveOrder() {
        // Create a new Order
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setTotal_amount(300);
        order.setStatus("Processing");

        // Save the order
        Order savedOrder = orderRepository.save(order);

        // Check that the saved order has an ID
        assertNotNull(savedOrder.getOrderId());
    }

    @Test
    public void testFindOrderById() {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setTotal_amount(200);
        order.setStatus("Delivered");

        Order savedOrder = orderRepository.save(order);

        Order foundOrder = orderRepository.findById(savedOrder.getOrderId()).orElse(null);

        assertNotNull(foundOrder);
        assertEquals(savedOrder.getOrderId(), foundOrder.getOrderId());
    }

    @Test
    public void testUpdateOrder() {
        // Create a new Order
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setTotal_amount(300);
        order.setStatus("Processing");

        // Save the order
        Order savedOrder = orderRepository.save(order);

        // Update the order
        savedOrder.setTotal_amount(400);
        savedOrder.setStatus("Complete");

        // Check if the order exists in the repository before saving
        Order orderInDB = orderRepository.findById(savedOrder.getOrderId()).orElse(null);
        if (orderInDB != null) {
            orderInDB.setTotal_amount(savedOrder.getTotal_amount());
            orderInDB.setStatus(savedOrder.getStatus());
            orderRepository.save(orderInDB);
        }

        // Retrieve the updated order
        Order updatedOrder = orderRepository.findById(savedOrder.getOrderId()).orElse(null);

        // Check that the updated order has the updated values
        assertNotNull(updatedOrder);
        assertEquals(savedOrder.getTotal_amount(), updatedOrder.getTotal_amount());
        assertEquals(savedOrder.getStatus(), updatedOrder.getStatus());
    }


    @Test
    public void testDeleteOrder() {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setTotal_amount(500);
        order.setStatus("Cancelled");

        Order savedOrder = orderRepository.save(order);

        orderRepository.deleteById(savedOrder.getOrderId());

        Order deletedOrder = orderRepository.findById(savedOrder.getOrderId()).orElse(null);

        assertNull(deletedOrder);
    }
}