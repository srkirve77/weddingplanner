package com.sample.starter.ds;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

import javax.persistence.Column;

@Entity
@AllArgsConstructor
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Integer orderId;
    @Column(name="customerId")
    private Integer customerId;
    @Column(name="vendor_id")
    private Integer vendorId;
    @Column(name="order_date")
    private LocalDate localDate;
    @Column(name="service_id")
    private Integer service_id;
    @Column(name="amount")
    private Integer amount;
    // public boolean PaymentGateway();
    // public boolean GenerateReceipt();

    public Order(Integer customerId,Integer vendorId, LocalDate localDate, Integer service_id,Integer amount)
    {
        this.customerId = customerId;
        this.vendorId = vendorId;
        this.localDate = localDate;
        this.service_id = service_id;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return this.localDate;
    }
}