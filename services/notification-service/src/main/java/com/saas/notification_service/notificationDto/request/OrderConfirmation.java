package com.saas.notification_service.notificationDto.request;

import com.saas.notification_service.enums.PaymentMethod;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Data
public class OrderConfirmation{
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private Customer customer;
    private List<Product> products;
}

