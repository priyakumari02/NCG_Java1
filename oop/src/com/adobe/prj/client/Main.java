package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Mobile(34, "iPhone 15", 99000.00, "5G"); // upcasting
        products[1] = new Tv(56, "Onida Thunder", 3500.00, "CRT");
        products[2] = new Tv(61, "Sony Bravia", 2_45_000.00, "OLED");
        products[3] = new Mobile(65, "Oppo", 8900, "4G");
        products[4] = new Mobile(90, "OnePlus 14", 78000, "4G");
//        products[5] = new Product();
        printExpensiveProducts(products);
       // printDetails(products);
        printDetailsOCP(products);
    }
    //OCP
    private static void printDetailsOCP(Product[] products) {
        for(Product p : products) {
          Method[] methods =  p.getClass().getMethods();
          for(Method m : methods) {
              if(m.getName().startsWith("get")) {
                // context.behaviour();
                  try {
                      Object ret = m.invoke(p);
                      System.out.println(m.getName().substring(3).toUpperCase() + " : " +ret);
                  } catch (Exception ex) {
                      ex.printStackTrace();
                  }
              }
          }
            System.out.println("*****");
        }
    }

    // OCP ? --> NO
    private static void printDetails(Product[] products) {
        for(Product p : products) {
            System.out.println(p.getName() +", " + p.getPrice());

            if(p instanceof Tv) {
                Tv t = (Tv) p;
                System.out.println(t.getScreenType());
            }
            if (p.getClass() == Mobile.class) {
                Mobile m = (Mobile) p;
                System.out.println(m.getConnectivity());
            }
            System.out.println("*******");
        }
    }

    // OCP
    private static void printExpensiveProducts(Product[] products) {
        for(Product p : products) {
            if ((p.isExpensive())) { //polymorphic
                System.out.println(p.getName() + " is expensive!!!");
            } else {
                System.out.println(p.getName() + " is not expensive!!!");
            }
        }
    }
}
