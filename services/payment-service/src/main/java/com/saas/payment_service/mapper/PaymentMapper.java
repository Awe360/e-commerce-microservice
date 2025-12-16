package com.saas.payment_service.mapper;


import com.saas.payment_service.dto.request.PaymentRequest;
import com.saas.payment_service.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment toPaymentEntity(PaymentRequest request){
        return Payment.builder()
                .amount(request.amount())
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .build();


    }
}
