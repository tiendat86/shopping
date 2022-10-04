package com.shopping.controller;

import com.shopping.common.UrlConst;
import com.shopping.dto.CustomerDTO;
import com.shopping.dto.request.CustomerItemForm;
import com.shopping.entity.Customer;
import com.shopping.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(UrlConst.ALL_CUSTOMER)
    public List <Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping(UrlConst.GET_CUSTOMER + "/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }

    @PostMapping (UrlConst.CREATE_CUSTOMER)
    public Customer createCustomer(@RequestBody CustomerDTO dto) {
        return customerService.createCustomer(dto);
    }

    @PostMapping (UrlConst.BUY_ITEM)
    public Customer buyItem(@RequestBody CustomerItemForm form) {
        return customerService.customerAddItem(form);
    }

}
