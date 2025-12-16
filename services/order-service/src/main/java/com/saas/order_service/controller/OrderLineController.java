package com.saas.order_service.controller;

import com.saas.order_service.dto.response.OrderLineResponse;
import com.saas.order_service.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> getOrderLinesByOrderId(@PathVariable("order-id") Integer orderId) {
        List<OrderLineResponse> orderLines = orderLineService.getByOrderId(orderId);
        return ResponseEntity.ok(orderLines);
    }


}
