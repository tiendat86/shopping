package com.shopping.controller;

import com.shopping.common.UrlConst;
import com.shopping.dto.ItemDTO;
import com.shopping.dto.response.CustomerResponseDTO;
import com.shopping.entity.Item;
import com.shopping.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping(UrlConst.CREATE_ITEM)
    public Item createItem(@RequestBody ItemDTO item) {
        return itemService.addItem(item);
    }

    @GetMapping(UrlConst.CUSTOMER_ORDER_ITEM + "/{id}")
    public Collection<CustomerResponseDTO> getCustomersOrder(@PathVariable Integer id) {
        return itemService.getCustomerOrderItem(id);
    }
}
