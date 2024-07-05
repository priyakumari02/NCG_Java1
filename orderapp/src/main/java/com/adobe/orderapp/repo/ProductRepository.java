package com.adobe.orderapp.repo;

import com.adobe.orderapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameIn(String [] names);
    List<Product> findByQuantity(int quantity); // select * from products where quantity = ?
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByPriceBetween(double low, double high);

    @Modifying
    @Query("update Product set price = :pr where id = :id")
    void updatePrice(@Param("id") int id, @Param("pr") double price);
}
