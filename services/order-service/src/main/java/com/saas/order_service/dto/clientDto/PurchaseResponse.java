package com.saas.order_service.dto.clientDto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Data
public class PurchaseResponse {
    private Integer productId;
    private Double quantity;
    private String name;
    private String description;
    private BigDecimal price;

}
