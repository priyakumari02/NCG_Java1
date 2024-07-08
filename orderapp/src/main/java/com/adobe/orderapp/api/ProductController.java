package com.adobe.orderapp.api;

import com.adobe.orderapp.entity.Product;
import com.adobe.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final OrderService service;

    // GET http://localhost:8080/api/products
    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    // GET http://localhost:8080/api/products/3
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return service.getProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public Product addProduct(@RequestBody Product p) {
        return service.saveProduct(p);
    }
}
