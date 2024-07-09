package com.adobe.orderapp.api;

import com.adobe.orderapp.entity.Order;
import com.adobe.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    // GET http://localhost:8080/api/orders
    
    // GET http://localhost:8080/api/orders?date=2024-07-05
    @GetMapping
    public List<Order> getOrders(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name="date" , required = false)LocalDate date) {
       if(date == null) {
           return service.getOrders();
       } else {
           return service.getOrderByDate(date);
       }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody Order o) {
        service.placeOrder(o);
        return "Order Placed!!!";
    }


}
