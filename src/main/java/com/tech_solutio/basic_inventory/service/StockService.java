package com.tech_solutio.basic_inventory.service;

import com.tech_solutio.basic_inventory.model.dto.ProductDto;
import com.tech_solutio.basic_inventory.model.dto.StockResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final ProductService productService;
    private static final int MINIMUM_STOCK_THRESHOLD = 10;

    public StockResponseDto checkStock(Long productId) {
        ProductDto product = productService.getProductById(productId);

        boolean belowMinimum = product.getStockQuantity() < MINIMUM_STOCK_THRESHOLD;
        String status = belowMinimum ? "LOW STOCK" : "ADEQUATE STOCK";

        StockResponseDto response = new StockResponseDto();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStockQuantity(product.getStockQuantity());
        response.setBelowMinimumStock(belowMinimum);
        response.setStockStatus(status);

        return response;
    }
}

