package com.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ItemDTO {
    private String name;
    private float price;
    private Integer idCategory;
}
