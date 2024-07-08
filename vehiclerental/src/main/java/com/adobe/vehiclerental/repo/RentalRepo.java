package com.adobe.vehiclerental.repo;

import com.adobe.vehiclerental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, Integer> {
}
