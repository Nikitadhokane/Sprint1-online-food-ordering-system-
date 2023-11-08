package com.sb.foodsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.foodsystem.entity.MenuType;


@Repository
public interface MenuTypeRepository extends JpaRepository<MenuType, Long> {

    List<MenuType> findByMenu_Id(Long id);
}

