package com.saas.order_service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class PurchaseRequest {

    @NotNull(message = "Product ID cannot be null")
    private Integer productId;
    @NotNull(message = "Quantity cannot be null")
    private Double quantity;

}
