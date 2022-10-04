package com.shopping.dto;

import com.shopping.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
public class CustomerDTO {
    private String name;
    private String address;
}
