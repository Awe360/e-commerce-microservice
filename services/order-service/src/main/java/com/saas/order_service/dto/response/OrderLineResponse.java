package com.saas.order_service.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Data

public class OrderLineResponse {

    Integer id;
    Integer productId;
    Integer orderId;
    double quantity;


}
