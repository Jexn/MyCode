package com.mars.services.Impl;

import com.mars.bean.Customer;
import com.mars.dao.CustomerDao;
import com.mars.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteCustomer(id);
    }

    @Override
    public void modifyCustomer(Customer id) {
        customerDao.modifyCustomer(id);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }
}
