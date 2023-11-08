package com.sb.foodsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.foodsystem.converter.AdminConverter;
import com.sb.foodsystem.dao.AdminRepository;
import com.sb.foodsystem.entity.Admin;
import com.sb.foodsystem.model.AdminDTO;
import com.sb.foodsystem.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminConverter adminConverter;

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin admin = adminConverter.dtoToEntity(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return adminConverter.entityToDto(savedAdmin);
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDTO> adminDTOs = new ArrayList<>();
        for (Admin admin : admins) {
            adminDTOs.add(adminConverter.entityToDto(admin));
        }
        return adminDTOs;
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            // handle the case when the admin is not found
            // throw an exception or return an error message
        }
        return adminConverter.entityToDto(admin);
    }

    @Override
    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
        Admin admin = adminConverter.dtoToEntity(adminDTO);
        admin.setId(id);
        Admin updatedAdmin = adminRepository.save(admin);
        return adminConverter.entityToDto(updatedAdmin);
    }

    @Override
    public String deleteAdmin(Long id) {
        adminRepository.deleteById(id);
        return "Admin with ID: " + id + " has been deleted";
    }
}