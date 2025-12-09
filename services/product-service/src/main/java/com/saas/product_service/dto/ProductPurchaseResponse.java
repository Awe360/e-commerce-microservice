package com.saas.product_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPurchaseResponse {
    Integer productId;
    String name;
    String description;
    BigDecimal price;
    double quantity;
}
