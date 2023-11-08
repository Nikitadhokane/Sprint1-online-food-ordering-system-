package com.sb.foodsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.foodsystem.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	//Login findByLoginId(Long loginId);

}
