package com.sb.foodsystem.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sb.foodsystem.dao.OrderDetailsRepository;
import com.sb.foodsystem.entity.OrderDetails;

@SpringBootTest
public class OrderDetailsRepositoryTest {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    
    @Test
    public void testCreateOrderDetails() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setAmount(25.0f);
        orderDetails.setTotalAmount(50.0f);
        orderDetails.setQuantity(2);

        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);

        assertNotNull(savedOrderDetails.getOrderDetailsId());
    }

    @Test
    public void testSaveOrderDetails() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setAmount(25.0f);
        orderDetails.setTotalAmount(50.0f);
        orderDetails.setQuantity(2);

        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);

        assertNotNull(savedOrderDetails.getOrderDetailsId());
    }
    
    @Test
    public void testFindAllOrderDetails() {
        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setAmount(25.0f);
        orderDetails1.setTotalAmount(50.0f);
        orderDetails1.setQuantity(2);

        OrderDetails orderDetails2 = new OrderDetails();
        orderDetails2.setAmount(30.0f);
        orderDetails2.setTotalAmount(60.0f);
        orderDetails2.setQuantity(2);

        orderDetailsRepository.save(orderDetails1);
        orderDetailsRepository.save(orderDetails2);

        List<OrderDetails> allOrderDetails = orderDetailsRepository.findAll();

        assertNotNull(allOrderDetails);
    }
    
    @Test
    public void testUpdateOrderDetails() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setAmount(25.0f);
        orderDetails.setTotalAmount(50.0f);
        orderDetails.setQuantity(2);

        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);

        // Modify an attribute of the orderDetails
        savedOrderDetails.setQuantity(3);
        OrderDetails updatedOrderDetails = orderDetailsRepository.save(savedOrderDetails);

        assertEquals(3, updatedOrderDetails.getQuantity());
    }

    @Test
    public void testFindOrderDetailsById() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setAmount(25.0f);
        orderDetails.setTotalAmount(50.0f);
        orderDetails.setQuantity(2);

        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);

        OrderDetails foundOrderDetails = orderDetailsRepository.findById(savedOrderDetails.getOrderDetailsId())
                .orElse(null);

        assertNotNull(foundOrderDetails);
    }
    
    @Test
    public void testDeleteOrderDetails() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setAmount(25.0f);
        orderDetails.setTotalAmount(50.0f);
        orderDetails.setQuantity(2);

        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);

        orderDetailsRepository.deleteById(savedOrderDetails.getOrderDetailsId());

        OrderDetails deletedOrderDetails = orderDetailsRepository.findById(savedOrderDetails.getOrderDetailsId())
                .orElse(null);

        assertNull(deletedOrderDetails);
    }
}


