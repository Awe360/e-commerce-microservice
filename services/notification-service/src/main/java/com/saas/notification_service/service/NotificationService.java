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
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentConfirmation(PaymentConfirmation paymentConfirmation){
        System.out.println("Payment Confirmation received: " + paymentConfirmation);
        Notification newNotification =new Notification();
        newNotification.setType(NotificationType.PAYMENT_CONFIRMATION);
        newNotification.setNotificationDate(LocalDateTime.now());
        newNotification.setPaymentConfirmation(paymentConfirmation);
        notificationRepository.save(newNotification);
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmation(OrderConfirmation orderConfirmation){
        System.out.println("Order Confirmation received: " + orderConfirmation);
        Notification orderNotification = new Notification();
        orderNotification.setType(NotificationType.ORDER_CONFIRMATION);
        orderNotification.setNotificationDate(LocalDateTime.now());
        orderNotification.setOrderConfirmation(orderConfirmation);
        notificationRepository.save(orderNotification);

    }
}
