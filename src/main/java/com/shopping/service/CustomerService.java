package com.shopping.service;

import com.shopping.dto.CustomerDTO;
import com.shopping.dto.request.CustomerItemForm;
import com.shopping.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDTO dto);
    Customer getCustomer(Integer id);
    List<Customer> getAllCustomers();
    Customer customerAddItem(CustomerItemForm form);
}
