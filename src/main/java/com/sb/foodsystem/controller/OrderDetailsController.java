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

import com.sb.foodsystem.converter.OrderDetailsConverter;
import com.sb.foodsystem.model.OrderDetailsDTO;
import com.sb.foodsystem.service.OrderDetailsService;

@RestController
//@RequestMapping("/orderdetails")
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {

	@Autowired
    private final OrderDetailsService orderDetailsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private final OrderDetailsConverter orderDetailsConverter;

   
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
		this.orderDetailsConverter = new OrderDetailsConverter();
    }

    @PostMapping("/orderDetails")
    public ResponseEntity<OrderDetailsDTO> createOrderDetails(@RequestBody OrderDetailsDTO orderDetailsDTO)
    {
        OrderDetailsDTO createdOrderDetails = orderDetailsService.createOrderDetails(orderDetailsDTO);
        return new ResponseEntity<>(createdOrderDetails, HttpStatus.CREATED);
    }

    @GetMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetailsDTO> getOrderDetailsById(@PathVariable Long id) 
    {
        OrderDetailsDTO orderDetails = orderDetailsService.getOrderDetailsById(id);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @PutMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetailsDTO> updateOrderDetails(@PathVariable Long id, @RequestBody OrderDetailsDTO orderDetailsDTO) 
    {
        OrderDetailsDTO updatedOrderDetails = orderDetailsService.updateOrderDetails(id, orderDetailsDTO);
        return new ResponseEntity<>(updatedOrderDetails, HttpStatus.OK);
    }

    @DeleteMapping("/orderDetails/{id}")
    public String deleteOrderDetails(@PathVariable Long id) 
    {
        return orderDetailsService.deleteOrderDetails(id);
    }
}
