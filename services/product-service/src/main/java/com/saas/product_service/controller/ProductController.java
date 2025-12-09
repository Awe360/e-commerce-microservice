package com.saas.product_service.controller;

import com.saas.product_service.dto.ProductPurchaseRequest;
import com.saas.product_service.dto.ProductPurchaseResponse;
import com.saas.product_service.dto.ProductRequest;
import com.saas.product_service.dto.ProductResponse;
import com.saas.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return ResponseEntity.ok("Product created successfully");

    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> productPurchase(@RequestBody @Valid List<ProductPurchaseRequest> productPurchaseRequests){
        List<ProductPurchaseResponse>purchases=productService.purchaseProducts(productPurchaseRequests);
        return ResponseEntity.ok(purchases);

    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("product-id") Integer productId){
        ProductResponse response=productService.getProductById(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> responses=productService.getAllProducts();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("product-id") Integer productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
}
}
