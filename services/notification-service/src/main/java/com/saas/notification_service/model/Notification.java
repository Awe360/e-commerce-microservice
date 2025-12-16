package com.saas.notification_service.model;


import com.saas.notification_service.notificationDto.request.OrderConfirmation;
import com.saas.notification_service.notificationDto.request.PaymentConfirmation;
import com.saas.notification_service.enums.NotificationType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class    Notification {
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
