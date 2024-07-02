package com.learnersacademy.service;

import java.util.List;

import com.learnersacademy.dao.AdminDao;
import com.learnersacademy.model.Admin;

public class AdminService {
    private AdminDao adminDAO = new AdminDao();

    public void addAdmin(Admin admin) {
        adminDAO.saveAdmin(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminDAO.getAdmins();
    }
}
