package com.saas.order_service.client;

import com.saas.order_service.dto.clientDto.PaymentRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="payment-service", url="${application.config.payment-service-url}")
public interface PaymentClient {
    @PostMapping
    Integer processPayment(@RequestBody PaymentRequestDto paymentRequest);

}
