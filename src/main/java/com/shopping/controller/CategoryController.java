package com.shopping.controller;

import com.shopping.common.UrlConst;
import com.shopping.dto.CategoryDTO;
import com.shopping.entity.Category;
import com.shopping.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping(UrlConst.CREATE_CATEGORY)
    public Category createCategory(@RequestBody CategoryDTO dto) {
        return categoryService.addCategory(dto);
    }
}
