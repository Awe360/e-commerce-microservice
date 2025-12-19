package com.saas.notification_service.notificationDto.request;

import com.saas.notification_service.enums.PaymentMethod;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
public class PaymentConfirmation{
        private String orderReference;
        private BigDecimal amount;
        private PaymentMethod paymentMethod;
        private String customerFirstname;
        private String customerLastname;
        private String customerEmail;
}
