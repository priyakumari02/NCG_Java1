package com.adobe.orderapp.service;

import com.adobe.orderapp.dto.OrderReport;
import com.adobe.orderapp.entity.Customer;
import com.adobe.orderapp.entity.LineItem;
import com.adobe.orderapp.entity.Order;
import com.adobe.orderapp.entity.Product;
import com.adobe.orderapp.exception.ResourceNotFoundException;
import com.adobe.orderapp.repo.CustomerRepository;
import com.adobe.orderapp.repo.OrderRepo;
import com.adobe.orderapp.repo.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private  final ProductRepository productRepo;
    private  final CustomerRepository customerRepo;

    private final OrderRepo orderRepo;

    @Transactional
    public Product updatePrice(int id, double price) {
        productRepo.updatePrice(id,price);
        return productRepo.findById(id).get();
    }

    public List<OrderReport> getReport() {
        return orderRepo.getReport();
    }
    /*
    oid is auto increment
    order_Date ==> system date
    {
        "customer": {"email": "anna@gmail.com"},
        "items": [
            {"product": {id: 5}, "qty": 2},
            {"product": {id: 4}, "qty": 1}
        ]
    }
     */
    @Transactional
    public String placeOrder(Order order) {
        double total = 0.0;
        for(LineItem item : order.getItems()) {
            Product p = productRepo.findById(item.getProduct().getId()).get();
            if(p.getQuantity() < item.getQty()) {
                throw  new IllegalArgumentException("Product " + p.getName() + " not in stock!!!");
            }
            p.setQuantity(p.getQuantity() - item.getQty()); // DIRTY CHECKING
            item.setAmount(p.getPrice() * item.getQty());
            total += item.getAmount();
        }
        order.setOrderDate(new Date());
        order.setTotal(total);
        orderRepo.save(order); // cascade takes care of saving items also
        return  "order placed!!!";
    }

    public List<Order> getOrders() {
        return  orderRepo.findAll();
    }


    public long getProductCount() {
        return productRepo.count();
    }

    public long getCustomerCount() {
        return customerRepo.count();
    }

    public Customer saveCustomer(Customer c) {
        return customerRepo.save(c);
    }

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product saveProduct(Product p) {
        return productRepo.save(p);
    }

    public Product getProductById(int id) throws ResourceNotFoundException {
        Optional<Product> opt = productRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get(); // return Product
        }
        throw new ResourceNotFoundException("Product with id " + id + " doesn't exist!!!");
    }

    public List<Product> byRange(double low, double high) {
        return productRepo.findByPriceBetween(low, high);
    }
}
