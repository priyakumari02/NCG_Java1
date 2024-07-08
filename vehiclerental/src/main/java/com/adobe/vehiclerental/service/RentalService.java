package com.adobe.vehiclerental.service;

import com.adobe.vehiclerental.entity.Rental;
import com.adobe.vehiclerental.entity.Vehicle;
import com.adobe.vehiclerental.repo.CustomerRepo;
import com.adobe.vehiclerental.repo.RentalRepo;
import com.adobe.vehiclerental.repo.VehicleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final CustomerRepo customerRepo;
    private final VehicleRepo vehicleRepo;
    private final RentalRepo rentalRepo;

    public long getVehicleCount() {
        return vehicleRepo.count();
    }

    public Vehicle addVehicle(Vehicle v) {
        return vehicleRepo.save(v);
    }

    public Rental rentAVehicle(Rental rental) {
        return rentalRepo.save(rental);
    }

    @Transactional
    public Rental returnVehicle(int id,  LocalDate returnDate) {
        Rental existingVehicle = rentalRepo.findById(id).get();
        existingVehicle.setRentTo(returnDate);
        return existingVehicle;
    }
}
