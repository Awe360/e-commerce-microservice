package com.saas.product_service.dto;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Data
public class ProductRequest {

    @NotNull(message = "Product name cannot be null")
    private String name;
    @NotNull(message = "Product description cannot be null")
    private String description;
    @NotNull(message = "Product price cannot be null")
    private BigDecimal price;

    @NotNull(message = "Category ID cannot be null")
    private Integer categoryId;

    @NotNull(message = "Available quantity cannot be null")
    private double availableQuantity;



}
