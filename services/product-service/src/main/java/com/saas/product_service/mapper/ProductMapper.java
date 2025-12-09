package com.saas.product_service.mapper;

import com.saas.product_service.dto.ProductRequest;
import com.saas.product_service.dto.ProductResponse;
import com.saas.product_service.model.Category;
import com.saas.product_service.model.Product;
import org.springframework.stereotype.Component;

@Component

public class ProductMapper {

    public Product mapToEntity(ProductRequest productRequest, Category category){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setAvailableQuantity(productRequest.getAvailableQuantity());
        product.setCategory(category);
        return product;
    }


    public ProductResponse mapToDto(Product product){
        ProductResponse productResponse=new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public Product mapUpdateRequest(Product product, ProductRequest productRequest){

        if(productRequest.getName()!=null){
            product.setName(productRequest.getName());
        }
        if(productRequest.getDescription()!=null){
            product.setDescription(productRequest.getDescription());
        }
        if(productRequest.getPrice()!=null){
            product.setPrice(productRequest.getPrice());
        }

        return product;
    }

}
