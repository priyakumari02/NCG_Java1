package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Mobile(34, "iPhone 15", 99000.00, "5G"); // upcasting
        products[1] = new Tv(56, "Onida Thunder", 3500.00, "CRT");
        products[2] = new Tv(61, "Sony Bravia", 2_45_000.00, "OLED");
        products[3] = new Mobile(65, "Oppo", 8900, "4G");
        products[4] = new Mobile(90, "OnePlus 14", 78000, "4G");

        
    }
}
