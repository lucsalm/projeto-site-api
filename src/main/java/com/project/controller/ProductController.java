package com.project.controller;


import com.project.model.Product;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    private Mono<Page<Product>> findProductsByPage(@RequestParam(value = "page", required = true) Integer page) {
        return productService.findProductsByPage(page);
    }

    @PostMapping("/admin/add")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Object> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
