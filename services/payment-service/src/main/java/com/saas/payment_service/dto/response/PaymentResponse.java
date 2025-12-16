package com.saas.payment_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public record PaymentResponse(
        Integer id,
        String orderId,
        Double amount,
        String paymentMethod,
        String status) {
}
