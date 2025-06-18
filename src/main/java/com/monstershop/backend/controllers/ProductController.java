package com.monstershop.backend.controllers;

import com.monstershop.backend.dtos.product.ProductRequest;
import com.monstershop.backend.dtos.product.ProductResponse;
import com.monstershop.backend.dtos.product.ProductMapper;
import com.monstershop.backend.models.Product;
import com.monstershop.backend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return service.getAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return ProductMapper.toDto(service.getById(id));
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        return ProductMapper.toDto(service.save(product));
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        product.setId(id);
        return ProductMapper.toDto(service.save(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}