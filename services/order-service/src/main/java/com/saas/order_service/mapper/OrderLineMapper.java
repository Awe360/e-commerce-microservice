package com.saas.order_service.mapper;

import com.saas.order_service.dto.request.OrderLineRequest;
import com.saas.order_service.dto.response.OrderLineResponse;
import com.saas.order_service.model.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {

    public OrderLine toOrderLineEntity(OrderLineRequest request){
        OrderLine orderLine = new OrderLine();
        orderLine.setProductId(request.getProductId());
        orderLine.setQuantity(request.getQuantity());
        return orderLine;
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine){
        OrderLineResponse response = new OrderLineResponse();
        response.setId(orderLine.getId());
        response.setProductId(orderLine.getProductId());
        response.setOrderId(orderLine.getOrder().getId());
        response.setQuantity(orderLine.getQuantity());
        return response;

    }
}
