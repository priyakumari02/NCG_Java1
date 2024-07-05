package com.adobe.orderapp.service;

import com.adobe.orderapp.entity.Product;
import com.adobe.orderapp.repo.CustomerRepository;
import com.adobe.orderapp.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private  final ProductRepository productRepo;
    private  final CustomerRepository customerRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product saveProduct(Product p) {
        return productRepo.save(p);
    }

    public Product getProductById(int id) {
        Optional<Product> opt = productRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get(); // return Product
        }
        return null;
    }

    public List<Product> byRange(double low, double high) {
        return productRepo.findByPriceBetween(low, high);
    }
}
