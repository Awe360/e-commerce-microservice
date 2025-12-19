package com.saas.notification_service.notificationDto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Data
public class Product {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;
}
