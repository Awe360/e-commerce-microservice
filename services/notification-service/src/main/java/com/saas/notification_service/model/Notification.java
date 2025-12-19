package com.saas.notification_service.model;

import com.saas.notification_service.notificationDto.request.OrderConfirmation;
import com.saas.notification_service.notificationDto.request.PaymentConfirmation;
import com.saas.notification_service.enums.NotificationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Notification {

    @Id
    private String id;

    private NotificationType type;

    private Date notificationDate;

    private OrderConfirmation orderConfirmation;

    private PaymentConfirmation paymentConfirmation;
}
