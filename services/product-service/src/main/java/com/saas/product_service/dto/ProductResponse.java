package com.saas.product_service.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Double availableQuantity;
    private Integer categoryId;
}
