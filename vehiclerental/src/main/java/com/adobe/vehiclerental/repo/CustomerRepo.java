package com.adobe.vehiclerental.repo;

import com.adobe.vehiclerental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
