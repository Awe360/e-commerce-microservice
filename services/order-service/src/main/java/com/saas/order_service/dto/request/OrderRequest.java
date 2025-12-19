package com.saas.order_service.dto.request;


import com.saas.order_service.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Data
public class OrderRequest {

    @NotBlank(message = "Reference cannot be blank")
    private String reference;

    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @NotNull(message = "Payment method cannot be null")
    private PaymentMethod paymentMethod;
    @NotBlank(message = "Customer ID cannot be blank")
    @NotNull(message = "Customer ID cannot be null")
    private String customerId;

    @NotNull(message = "Products list cannot be null")
    @NotEmpty(message = "There must be at least one product in the order")
    private  List<PurchaseRequest> products;



}
