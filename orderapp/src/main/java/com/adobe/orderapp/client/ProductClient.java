package com.adobe.orderapp.client;

import com.adobe.orderapp.entity.Product;
import com.adobe.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductClient implements CommandLineRunner {
    private final OrderService service;

    @Override
    public void run(String... args) throws Exception {
        addProducts();
        printProducts();
    }

    private void printProducts() {
        for(Product p : service.getProducts()) {
            System.out.println(p);
        }
    }

    private void addProducts() {
        if(service.getProductCount() ==0) {
            service.saveProduct(Product.builder()
                    .name("Bosch Dishwasher").price(54000.00)
                    .quantity(100).build());
            service.saveProduct(Product.builder()
                    .name("LG Microwave").price(14000.00)
                    .quantity(100).build());
        }
    }
}
