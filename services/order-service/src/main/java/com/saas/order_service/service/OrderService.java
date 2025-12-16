package com.saas.order_service.service;

import com.saas.order_service.client.CustomerClient;
import com.saas.order_service.client.PaymentClient;
import com.saas.order_service.client.ProductClient;
import com.saas.order_service.dto.clientDto.CustomerResponse;
import com.saas.order_service.dto.clientDto.OrderConfirmation;
import com.saas.order_service.dto.clientDto.PaymentRequestDto;
import com.saas.order_service.dto.request.OrderLineRequest;
import com.saas.order_service.dto.request.OrderRequest;
import com.saas.order_service.dto.request.PurchaseRequest;
import com.saas.order_service.dto.response.OrderResponse;
import com.saas.order_service.exception.ResourceNotFoundException;
import com.saas.order_service.kafka.OrderProducer;
import com.saas.order_service.mapper.OrderMapper;
import com.saas.order_service.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Transactional
    public Integer createOrder(@Valid OrderRequest orderRequest) {


        CustomerResponse customer = customerClient.getCustomerById(orderRequest.getCustomerId())
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found with ID: " + orderRequest.getCustomerId()));
        var purchasedProducts = productClient.purchaseProducts(orderRequest.getProducts());
        var order = orderRepository.save(orderMapper.toOrderEntity(orderRequest));
        for(PurchaseRequest purchaseRequest : orderRequest.getProducts()){
            orderLineService.saveOrderLine(new OrderLineRequest(null,order.getId(),purchaseRequest.getProductId(),purchaseRequest.getQuantity()));
                    }

        orderProducer.sendOrderConfirmation(new OrderConfirmation(
                orderRequest.getReference(),
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                customer,
                purchasedProducts

        ));
        var paymentRequst = new PaymentRequestDto(
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                order.getId(),
                orderRequest.getReference(),
                customer
        );
        paymentClient.processPayment(paymentRequst);

        return order.getId();










    }

    @Transactional
    public List<OrderResponse> findAllOrders() {
        var orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    @Transactional
    public OrderResponse findOrderById(Integer id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
        return orderMapper.toOrderResponse(order);
    }

    @Transactional
    public void deleteOrderById(Integer id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
        orderRepository.delete(order);
    }




}
