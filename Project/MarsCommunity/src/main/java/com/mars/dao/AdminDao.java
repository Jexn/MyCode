package com.mars.dao;

import com.mars.bean.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    Admin findAdminByUserName(String username);
}
