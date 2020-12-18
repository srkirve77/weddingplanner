package com.sample.starter.ds;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Catering{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="catering_id")
    private Integer cateringId;
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
    //public void CateringRegistration(Catering catering);
    public Catering(String name,Integer price,Integer capacity,String location) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
    }

    public  void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public  Integer getVendorId() {
        return this.vendorId;
    }

    public Integer getPrice() {
        return this.price;
    }

       
}