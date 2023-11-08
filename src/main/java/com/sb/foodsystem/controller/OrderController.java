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

import com.sb.foodsystem.converter.OrderConverter;
import com.sb.foodsystem.model.OrderDTO;
import com.sb.foodsystem.service.OrderService;

@RestController
//@RequestMapping("/orders")
@RequestMapping("/api/orders")
public class OrderController {

	 @Autowired
	 private final OrderService orderService;
	 
	 @SuppressWarnings("unused")
	 @Autowired
	 private final OrderConverter orderConverter;

   
	 public OrderController(OrderService orderService, OrderConverter orderConverter) 
	 {
        this.orderService = orderService;
        this.orderConverter = orderConverter;
	 }

	 @PostMapping("/order")
	 public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) 
	 {
	      OrderDTO createdOrder = orderService.createOrder(orderDTO);
	      return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	 }

	 @GetMapping("/order/{order_id}")
	  public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId) 
	  {
	     OrderDTO order = orderService.getOrderById(orderId);
	     return new ResponseEntity<>(order, HttpStatus.OK);
	  }

	  @PutMapping("/order/{order_id}")
	  public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long ordeId, @RequestBody OrderDTO orderDTO) 
	  {
	      OrderDTO updatedOrder = orderService.updateOrder(ordeId, orderDTO);
	      return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
	  }

     @DeleteMapping("/order/{orderId}")
     public String deleteOrder(@PathVariable Long orderId)
     {
        return orderService.deleteOrder(orderId);
     }
}