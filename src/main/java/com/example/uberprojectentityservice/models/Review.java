package com.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking_review")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","booking"})
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking; //one to one relationship between booking and review

  @Override
    public String toString() {
      return "Review"+this.content+" "+this.rating+" "+"bookingId"+this.booking.getId()+""+this.createdAt;
  }
//    private String content;
//
//    private String createdOn;
//
//    private String modifiedOn;
}
