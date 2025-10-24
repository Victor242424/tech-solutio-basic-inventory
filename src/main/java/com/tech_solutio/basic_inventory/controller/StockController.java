package com.tech_solutio.basic_inventory.controller;

import com.tech_solutio.basic_inventory.model.dto.StockResponseDto;
import com.tech_solutio.basic_inventory.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StockController {

    private final StockService stockService;

    @GetMapping("/{productId}")
    public ResponseEntity<StockResponseDto> checkStock(@PathVariable Long productId) {
        return ResponseEntity.ok(stockService.checkStock(productId));
    }
}
