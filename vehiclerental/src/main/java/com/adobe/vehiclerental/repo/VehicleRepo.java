package com.adobe.vehiclerental.repo;

import com.adobe.vehiclerental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {
}
