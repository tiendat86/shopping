package com.shopping.service.impl;

import com.shopping.dto.CategoryDTO;
import com.shopping.entity.Category;
import com.shopping.repository.CategoryRepository;
import com.shopping.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public Category addCategory(CategoryDTO category) {
        return categoryRepository.save(modelMapper.map(category, Category.class));
    }
}
