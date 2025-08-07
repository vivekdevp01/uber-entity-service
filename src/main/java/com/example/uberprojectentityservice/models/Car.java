package com.example.uberprojectentityservice.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car extends  BaseModel {

    @Column(unique = true,nullable = false)
    private String plateNumber;

    private String brand;

    private String model;

    @ManyToOne
    private Color color;

    @Enumerated(value = EnumType.STRING)
    private CarType carType;

    @OneToOne
    private Driver driver;
}
