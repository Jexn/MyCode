package com.mars.dao;

import com.mars.bean.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {
    void saveCustomer(Customer customer);
    void deleteCustomer(Integer id);
    void modifyCustomer(Customer id);
    Customer findCustomerById(Integer id);
    List<Customer> findAllCustomer();
}
