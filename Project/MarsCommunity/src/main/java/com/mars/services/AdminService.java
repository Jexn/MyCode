package com.mars.services;

import com.mars.bean.Admin;

public interface AdminService {
    Admin findAdminByUserName(String username);
}
