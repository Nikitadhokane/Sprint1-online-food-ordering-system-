package com.sb.foodsystem.converter;

import org.springframework.stereotype.Component;

import com.sb.foodsystem.entity.Admin;
import com.sb.foodsystem.model.AdminDTO;


@Component
public class AdminConverter {

    public AdminDTO entityToDto(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setPassword(admin.getPassword());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setContact(admin.getContact());
        return adminDTO;
    }

    public Admin dtoToEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());
        admin.setContact(adminDTO.getContact());
        return admin;
    }
}