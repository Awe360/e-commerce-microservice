package com.saas.order_service.dto.response;

import com.saas.order_service.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class OrderResponse {
    private Integer id;
    private String customerId;
    private String reference;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
}
