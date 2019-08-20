package com.mars.services.Impl;

import com.mars.bean.Admin;
import com.mars.dao.AdminDao;
import com.mars.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin findAdminByUserName(String username) {
        return adminDao.findAdminByUserName(username);
    }
}
