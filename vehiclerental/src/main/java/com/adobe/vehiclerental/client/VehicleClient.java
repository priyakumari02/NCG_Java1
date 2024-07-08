package com.adobe.vehiclerental.client;

import com.adobe.vehiclerental.entity.Vehicle;
import com.adobe.vehiclerental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class VehicleClient implements CommandLineRunner {
    private final RentalService service;
    @Override
    public void run(String... args) throws Exception {
        if(service.getVehicleCount() == 0) {
            service.addVehicle(Vehicle.builder()
                            .registrationNumber("KA01EF1234")
                            .costPerDay(2500.00)
                            .fuelType("PETROL")
                    .build());

            service.addVehicle(Vehicle.builder()
                    .registrationNumber("DA23A9013")
                    .costPerDay(3200.00)
                    .fuelType("ELECTRIC")
                    .build());

            service.addVehicle(Vehicle.builder()
                    .registrationNumber("KA50E9000")
                    .costPerDay(2800.00)
                    .fuelType("PETROL")
                    .build());
        }
    }
}
