package com.sample.starter.repository;

import com.sample.starter.ds.*;
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
public interface  CateringRepository extends CrudRepository<Catering,Long> {
    @Query(value = "SELECT * FROM catering  WHERE catering_id = :cateringId",nativeQuery=true)
    List<Catering> findUserByStatusNative(@Param("cateringId") Integer cateringId);
}