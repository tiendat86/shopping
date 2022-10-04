package com.shopping.service.impl;

import com.shopping.dto.CustomerDTO;
import com.shopping.dto.request.CustomerItemForm;
import com.shopping.entity.Customer;
import com.shopping.entity.Item;
import com.shopping.repository.CustomerRepository;
import com.shopping.repository.ItemRepository;
import com.shopping.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public Customer createCustomer(CustomerDTO dto) {
        return customerRepository.save(modelMapper.map(dto, Customer.class));
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer customerAddItem(CustomerItemForm form) {
        try {
            Customer customer = customerRepository.findById(form.getIdCustomer()).get();
            Item item = itemRepository.findById(form.getIdItem()).get();
            customer.getItems().add(item);
//            item.getCustomers().add(customer);
            customerRepository.save(customer);
            return customer;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không tồn tại user hoặc item");
        }
    }
}
