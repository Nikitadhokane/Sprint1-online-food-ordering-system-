package com.sb.foodsystem.service;

import java.util.List;

import com.sb.foodsystem.model.AdminDTO;

public interface AdminService {
	
	AdminDTO createAdmin(AdminDTO admin);

    List<AdminDTO> getAllAdmins();

    AdminDTO getAdminById(Long id);

    AdminDTO updateAdmin(Long id, AdminDTO admin);

    String deleteAdmin(Long id);
}