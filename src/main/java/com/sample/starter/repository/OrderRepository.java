package com.sample.starter.repository;

import com.sample.starter.ds.Order;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface  OrderRepository extends CrudRepository<Order,Long> {
    @Query(value = "SELECT * FROM order  WHERE service_id = :service_id",nativeQuery=true)
    List<Order> findUserByStatusNative(@Param("service_id") Integer service_id);
}