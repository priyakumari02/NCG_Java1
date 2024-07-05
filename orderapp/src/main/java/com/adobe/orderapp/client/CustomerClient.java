package com.adobe.orderapp.client;

import com.adobe.orderapp.entity.Customer;
import com.adobe.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(2)
public class CustomerClient implements CommandLineRunner {
    private final OrderService service;

    @Override
    public void run(String... args) throws Exception {
        addCustomers();
    }

    private void addCustomers() {
        if(service.getCustomerCount() ==0) {
           service.saveCustomer(Customer.builder().
                   email("roger@gmail.com").firstName("Roger").lastName("Smith")
                   .build());
            service.saveCustomer(Customer.builder().
                    email("anna@gmail.com").firstName("Anna").lastName("Hathaway")
                    .build());
        }
    }
}
