package com.adobe.vehiclerental.client;

import com.adobe.vehiclerental.entity.Customer;
import com.adobe.vehiclerental.entity.Rental;
import com.adobe.vehiclerental.entity.Vehicle;
import com.adobe.vehiclerental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Order(2)
public class RentalClient implements CommandLineRunner {
    private final RentalService service;
    @Override
    public void run(String... args) throws Exception {
//        rent();
        returnVehicle();
    }

    private void returnVehicle() {
        service.returnVehicle(1, LocalDate.of(2024, 1, 28));
    }

    private void rent() {
        Rental rental = new Rental();
        rental.setCustomer(Customer.builder().email("anna@gmail.com").build());
        rental.setVehicle(Vehicle.builder().registrationNumber("DA23A9013").build());
        rental.setRentFrom(LocalDate.of(2024, 1, 25));
        service.rentAVehicle(rental);
    }


}
