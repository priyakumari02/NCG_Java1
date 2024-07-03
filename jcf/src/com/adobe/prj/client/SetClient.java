package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetClient {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(42, "Samsung OLED", 2_30_000.00, "tv"));
        products.add(new Product(75, "Wacom", 5000.00, "computer"));
        products.add(new Product(91, "OnePlus 15", 80_000.00, "mobile"));
        products.add(new Product(12, "iPhone 15", 1_30_000.00, "mobile"));
        products.add(new Product(800, "Logitech Mouse", 900.00, "computer"));
        products.add(new Product(766, "Sony Bravia", 3_10_000.00, "tv"));

        for(Product p : products) {
            System.out.println(p);
        }
    }
}
