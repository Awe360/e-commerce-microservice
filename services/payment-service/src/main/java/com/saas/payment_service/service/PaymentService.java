package com.saas.payment_service.service;

import com.saas.payment_service.dto.request.PaymentRequest;
import com.saas.payment_service.mapper.PaymentMapper;
import com.saas.payment_service.model.Payment;
import com.saas.payment_service.notification.NotificationProducer;
import com.saas.payment_service.notification.PaymentNotificationRequest;
import com.saas.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;


        public Integer createPayment(PaymentRequest request) {
            var payment = this.repository.save(this.mapper.toPaymentEntity(request));

            this.notificationProducer.sendNotification(
                    new PaymentNotificationRequest(
                            request.orderReference(),
                            request.amount(),
                            request.paymentMethod(),
                            request.customer().firstName(),
                            request.customer().lastName(),
                            request.customer().email()
                    )
            );
            return payment.getId();
        }

}
