package com.example.uberprojectentityservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties( {"hibernateLazyInitializer","handler","bookings"})

public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;



    private String address;

    private String phoneNumber;

    private String email;

    private String adharCard;

    @OneToOne(mappedBy = "driver" ,cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    @DecimalMin(value = "0.00",message = "Rating must be greater than or equal to 0.00")
    @DecimalMax(value = "5.00",message = "Rating must be less than or equal to 5.00")
    private double rating;

    //    1:n dirver has many booking
    @OneToMany(mappedBy = "driver",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings=new ArrayList<>();
}

