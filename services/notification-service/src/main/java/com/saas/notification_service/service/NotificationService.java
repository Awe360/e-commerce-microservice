package com.saas.notification_service.service;

import com.saas.notification_service.enums.NotificationType;
import com.saas.notification_service.model.Notification;
import com.saas.notification_service.notificationDto.request.OrderConfirmation;
import com.saas.notification_service.notificationDto.request.PaymentConfirmation;
import com.saas.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic", groupId = "paymentGroup")
    public void consumePaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        log.info("Payment Confirmation received: {}", paymentConfirmation);

        Notification notification = new Notification();
        notification.setType(NotificationType.PAYMENT_CONFIRMATION);
        notification.setNotificationDate(new Date());
        notification.setPaymentConfirmation(paymentConfirmation);

        notificationRepository.save(notification);
        log.info("Payment notification saved successfully for order reference: {}",
                paymentConfirmation.getOrderReference());


        var customerName = paymentConfirmation.getCustomerFirstname() + " " + paymentConfirmation.getCustomerLastname();

        try{
            emailService.sendPaymentSuccessEmail(
                    paymentConfirmation.getCustomerEmail(),
                    customerName,
                    paymentConfirmation.getAmount(),
                    paymentConfirmation.getOrderReference()
            );
        }
        catch (Exception e){
            log.error("Failed to send payment success email to {}: {}", paymentConfirmation.getCustomerEmail(), e.getMessage());
            return;
        }




    }


    @KafkaListener(topics = "order-topic", groupId = "orderGroup")
    public void consumeOrderConfirmation(OrderConfirmation orderConfirmation) {
        log.info("Order Confirmation received: {}", orderConfirmation);

        Notification notification = new Notification();
        notification.setType(NotificationType.ORDER_CONFIRMATION);
        notification.setNotificationDate(new Date());
        notification.setOrderConfirmation(orderConfirmation);

        notificationRepository.save(notification);

        var customerName = orderConfirmation.getCustomer().getFirstName() + " " + orderConfirmation.getCustomer().getLastName();

        try{
            emailService.sendOrderConfirmationEmail(
                    orderConfirmation.getCustomer().getEmail(),
                    customerName,
                    orderConfirmation.getTotalAmount(),
                    orderConfirmation.getOrderReference(),
                    orderConfirmation.getProducts()
            );
        }
        catch (Exception e){
            log.error("Failed to send order success email to {}: {}", orderConfirmation.getCustomer().getEmail(), e.getMessage());
            return;
        }


        log.info("Order notification saved successfully for order reference: {}",
                orderConfirmation.getOrderReference());
    }
}