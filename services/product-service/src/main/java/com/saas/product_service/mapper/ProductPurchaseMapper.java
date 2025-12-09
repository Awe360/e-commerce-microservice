package com.saas.product_service.mapper;

import com.saas.product_service.dto.ProductPurchaseRequest;
import com.saas.product_service.dto.ProductPurchaseResponse;
import com.saas.product_service.model.Product;
import org.springframework.stereotype.Component;

@Component

public class ProductPurchaseMapper {

    public ProductPurchaseResponse toproductPurchaseResponse(Product product) {
        ProductPurchaseResponse response = new ProductPurchaseResponse();
        response.setProductId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getAvailableQuantity());
        return response;
    }



}
