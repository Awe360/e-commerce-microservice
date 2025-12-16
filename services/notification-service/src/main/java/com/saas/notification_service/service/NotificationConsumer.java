package com.saas.notification_service.service;

import com.saas.notification_service.enums.NotificationType;
import com.saas.notification_service.model.Notification;
import com.saas.notification_service.notificationDto.request.OrderConfirmation;
import com.saas.notification_service.notificationDto.request.PaymentConfirmation;
import com.saas.notification_service.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentConfirmation(PaymentConfirmation paymentConfirmation){
        System.out.println("Payment Confirmation received: " + paymentConfirmation);
        notificationRepository.save(Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build());
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmation(OrderConfirmation orderConfirmation){
        System.out.println("Order Confirmation received: " + orderConfirmation);
        notificationRepository.save(Notification.builder()
                .type(NotificationType.ORDER_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .build());
    }
}
