package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductClient {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(42, "Samsung OLED", 2_30_000.00, "tv"));
        products.add(new Product(75, "Wacom", 5000.00, "computer"));
        products.add(new Product(91, "OnePlus 15", 80_000.00, "mobile"));
        products.add(new Product(12, "iPhone 15", 1_30_000.00, "mobile"));
        products.add(new Product(800, "Logitech Mouse", 900.00, "computer"));
        products.add(new Product(766, "Sony Bravia", 3_10_000.00, "tv"));

//        products.get(3);
//        products.add(4, new Product());
        // Collections.reverse(products);
       // Collections.sort(products); // comparable
     //  Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        // sort by name
        Collections.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        for(Product p: products) {
            System.out.println(p); // toString()
        }
        System.out.println("get Mobiles");

      //  products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(p -> System.out.println(p));
  //      products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(System.out::println);
    List<Product> mobiles =
            products.stream().filter(p -> p.getCategory().equals("mobile")).collect(Collectors.toList());

        System.out.println("get names");
        List<String> names = products.stream().map( p -> p.getName()).collect(Collectors.toList());
        for(String name: names) {
            System.out.println(name);
        }

        System.out.println("get Name and price");

        record ProductDTO(String name, double price) {
        }

        List<ProductDTO> dtos = products.stream().map( p -> new ProductDTO(p.getName(), p.getPrice()))
                    .collect(Collectors.toList());

        for(ProductDTO dt: dtos) {
            System.out.println(dt);
        }

        System.out.println("Sum of products");

        double total = products.stream().map(p -> p.getPrice()).reduce(0.0 , (v1, v2) -> v1 + v2);
        System.out.println("Total " + total);

       Map<String, List<Product>> productMap
               = products.stream().collect(Collectors.groupingBy(p -> p.getCategory()));

       Set<String> keys = productMap.keySet();
       for(String key : keys) {
           System.out.println(key);
       }

       List<Product> tvs = productMap.get("tv");
       for(Product p : tvs) {
           System.out.println(p);
       }

       productMap.forEach((key, value) -> {
           System.out.println(key);
           value.forEach(System.out::println);
       });
    }
}

