package com.sb.foodsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.foodsystem.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
	
	//Order findByOrderId(Long orderId);
}
