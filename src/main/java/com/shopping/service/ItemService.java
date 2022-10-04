package com.shopping.service;

import com.shopping.dto.ItemDTO;
import com.shopping.dto.response.CustomerResponseDTO;
import com.shopping.entity.Customer;
import com.shopping.entity.Item;

import java.util.Collection;

public interface ItemService {
    Item addItem(ItemDTO itemDTO);
    Collection<CustomerResponseDTO> getCustomerOrderItem(Integer id);
}
