package com.sample.starter.ds;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import javax.persistence.Column;

@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Venue{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="venue_id")
    private Integer venueId;
    @Column(name="vendor_id")
    private Integer vendorId;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Integer price;
    @Column(name="capacity")
    private Integer capacity;
    @Column(name="location")
    private String location;
    public Venue(String name,Integer price,Integer capacity,String location) {
        this.venueId = 1;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
    }
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }
    //public void VenueRegistration(Venue venue);
}