package com.sample.starter.repository;

import com.sample.starter.ds.Customer;
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
public interface  CustomerRepository extends CrudRepository<Customer,Long> {
    @Query(value = "SELECT * FROM customer  WHERE user_name = :username",nativeQuery=true)
    List<Customer> findUserByStatusNative(@Param("username") String username);
    //public List<Customer> findAll();
}