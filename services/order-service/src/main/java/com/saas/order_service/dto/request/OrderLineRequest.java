package com.saas.order_service.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.lang.*;

@Data
@AllArgsConstructor
public class OrderLineRequest {

    Integer id;
    Integer productId;
    Integer orderId;
    double quantity;

}
