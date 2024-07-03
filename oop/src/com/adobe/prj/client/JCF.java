package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.util.Utility;

import java.util.Arrays;
import java.util.Comparator;

public class JCF {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Mobile(34, "iPhone 15", 99000.00, "5G"); // upcasting
        products[1] = new Tv(56, "Onida Thunder", 3500.00, "CRT");
        products[2] = new Tv(61, "Sony Bravia", 2_45_000.00, "OLED");
        products[3] = new Mobile(5, "Oppo", 8900, "4G");
        products[4] = new Mobile(90, "OnePlus 14", 78000, "4G");

       // Comparator nameComparator = new NameComparator();

//        Comparator nameComparator = new Comparator() {
//
//            @Override
//            public int compare(Object o1, Object o2) {
//                Product p1 = (Product) o1;
//                Product p2 = (Product) o2;
//                return p1.getName().compareTo(p2.getName());
//            }
//        };

//        Comparator<Product> nameComparator = new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p1.getName().compareTo(p2.getName());
//            }
//        };

        Comparator<Product> nameComparator = (Product p1, Product p2) -> p1.getName().compareTo(p2.getName());

       // Arrays.sort(products);
        Arrays.sort(products, nameComparator);
       // Utility.sort(products);
        for (Product p : products) {
            System.out.println(p.getId() + ", " + p.getName());
        }
    }
}
