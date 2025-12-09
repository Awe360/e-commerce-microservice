package com.saas.product_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductPurchaseRequest {

    @NotNull(message = "Product ID cannot be null")
    private Integer productId;
    @NotNull(message = "Quantity cannot be null")
    private double quantity;
}
