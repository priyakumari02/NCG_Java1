package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ProductClient {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(42, "Samsung OLED", 2_30_000.00, "tv"));
        products.add(new Product(75, "Wacom", 5000.00, "computer"));
        products.add(new Product(91, "OnePlus 15", 80_000.00, "mobile"));
        products.add(new Product(12, "iPhone 15", 1_30_000.00, "mobile"));
        products.add(new Product(800, "Logitech Mouse", 900.00, "computer"));
        products.add(new Product(766, "Sony Bravia", 3_10_000.00, "tv"));

       // Collections.sort(products); // comparable
        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        // sort by name
        for(Product p: products) {
            System.out.println(p); // toString()
        }
    }
}

