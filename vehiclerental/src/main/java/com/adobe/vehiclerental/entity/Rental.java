package com.adobe.vehiclerental.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "RENT_FROM_DATE")
    private LocalDate rentFrom;

    @Column(name = "RENT_TO_DATE")
    private LocalDate rentTo;

    @ManyToOne
    @JoinColumn(name = "vehicle_fk")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer;

}
