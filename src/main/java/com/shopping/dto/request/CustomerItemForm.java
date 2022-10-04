package com.shopping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerItemForm {
    private Integer idCustomer;
    private Integer idItem;
}
