package com.shopping.service.impl;

import com.shopping.dto.ItemDTO;
import com.shopping.dto.response.CustomerResponseDTO;
import com.shopping.entity.Item;
import com.shopping.repository.CategoryRepository;
import com.shopping.repository.ItemRepository;
import com.shopping.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Item addItem(ItemDTO itemDTO) {
        Item item = modelMapper.map(itemDTO, Item.class);
        try {
            item.setCategory(categoryRepository.findById(itemDTO.getIdCategory()).get());
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category isn't exist!");
        }
    }

    @Override
    public Collection<CustomerResponseDTO> getCustomerOrderItem(Integer id) {
        try {
            Item item = itemRepository.findById(id).get();
            return item.getCustomers()
                    .stream()
                    .map(customer -> modelMapper.map(customer, CustomerResponseDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id isn't exist!");
        }
    }
}
