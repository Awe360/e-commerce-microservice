package com.saas.order_service.mapper;


import com.saas.order_service.dto.clientDto.CustomerResponse;
import com.saas.order_service.dto.clientDto.PurchaseResponse;
import com.saas.order_service.dto.request.OrderRequest;
import com.saas.order_service.dto.response.OrderResponse;
import com.saas.order_service.model.Order;
import org.springframework.stereotype.Component;

@Component

public class OrderMapper {

    public Order toOrderEntity(OrderRequest orderRequest) {
        Order order = new Order();
        order.setReference(orderRequest.getReference());
        order.setCustomerId(orderRequest.getCustomerId());
        order.setTotalAmount(orderRequest.getAmount());
        order.setPaymentMethod(orderRequest.getPaymentMethod());
        return order;


    }

    public OrderResponse toOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setReference(order.getReference());
        orderResponse.setCustomerId(order.getCustomerId());
        orderResponse.setAmount(order.getTotalAmount());
        orderResponse.setPaymentMethod(order.getPaymentMethod());
        return orderResponse;
    }



}
