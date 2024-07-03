package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

public class ProductWriteClient {
    public static void main(String[] args) {
        Product p = Product.builder()
                .name("LG AC")
                .price(45000.00)
                .quantity(100)
                .build();
    }
}
