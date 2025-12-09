package com.saas.product_service.service;


import com.saas.product_service.dto.ProductPurchaseRequest;
import com.saas.product_service.dto.ProductPurchaseResponse;
import com.saas.product_service.dto.ProductRequest;
import com.saas.product_service.dto.ProductResponse;
import com.saas.product_service.exception.ProductPurchaseException;
import com.saas.product_service.mapper.ProductMapper;
import com.saas.product_service.mapper.ProductPurchaseMapper;
import com.saas.product_service.model.Product;
import com.saas.product_service.repository.CategoryRepository;
import com.saas.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductPurchaseMapper productPurchaseMapper;
    private final CategoryRepository categoryRepository;



    public String createProduct(ProductRequest productRequest) {

        var category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + productRequest.getCategoryId()));

        Product product = productMapper.mapToEntity(productRequest, category);

        productRepository.save(product);

        return "Product created successfully";
    }


    public List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    ) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.getQuantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.getProductId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productPurchaseMapper.toproductPurchaseResponse(product));
        }
        return purchasedProducts;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products=productRepository.findAll();
        return products.stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    public ProductResponse getProductById(Integer productId){
        Product product=productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
        return productMapper.mapToDto(product);
    }

    public String deleteProduct(Integer productId){
        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }




}
