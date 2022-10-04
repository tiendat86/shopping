package com.shopping.service;

import com.shopping.dto.CategoryDTO;
import com.shopping.entity.Category;

public interface CategoryService {
    Category addCategory(CategoryDTO category);
}
