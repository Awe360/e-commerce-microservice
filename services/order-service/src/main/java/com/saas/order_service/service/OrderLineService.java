package com.saas.order_service.service;

import com.saas.order_service.dto.request.OrderLineRequest;
import com.saas.order_service.dto.response.OrderLineResponse;
import com.saas.order_service.mapper.OrderLineMapper;
import com.saas.order_service.model.OrderLine;
import com.saas.order_service.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public Integer saveOrderLine(OrderLineRequest request) {
        OrderLine orderLine=orderLineRepository.save(orderLineMapper.toOrderLineEntity(request));
        return orderLine.getId();
    }

    public List<OrderLineResponse>getByOrderId(Integer orderId){
        List<OrderLine> orderLines=orderLineRepository.findAll().stream()
                .filter(ol->ol.getOrder().getId().equals(orderId))
                .toList();
        return orderLines.stream()
                .map(orderLineMapper::toOrderLineResponse)
                .toList();
    }



}
