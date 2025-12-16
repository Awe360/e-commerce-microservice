package com.saas.order_service.dto.clientDto;

import com.saas.order_service.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequestDto(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
