package com.mars.services;

import com.mars.bean.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void deleteCustomer(Integer id);
    void modifyCustomer(Customer id);
    Customer findCustomerById(Integer id);
    List<Customer> findAllCustomer();
}
