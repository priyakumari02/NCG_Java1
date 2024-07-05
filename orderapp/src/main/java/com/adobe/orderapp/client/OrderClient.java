package com.adobe.orderapp.client;

import com.adobe.orderapp.entity.Customer;
import com.adobe.orderapp.entity.LineItem;
import com.adobe.orderapp.entity.Order;
import com.adobe.orderapp.entity.Product;
import com.adobe.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderClient implements CommandLineRunner {
    private final OrderService service;
    @Override
    public void run(String... args) throws Exception {
        checkout();
       // printOrders();
    }

    private void printOrders() {
        for(Order o : service.getOrders()){
            System.out.println(o);
            for (LineItem item : o.getItems()) {
                System.out.println(item);
            }
        }
    }

    private void checkout() {
        List<LineItem> items = new ArrayList<>();
        items.add(LineItem.builder().product(Product.builder().id(5).build()).qty(2).build());
        items.add(LineItem.builder().product(Product.builder().id(1).build()).qty(3).build());

        Order order = Order.builder()
                .customer(Customer.builder().email("roger@gmail.com").build())
                .items(items)
                .build();

        service.placeOrder(order);
    }


}
