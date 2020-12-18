package com.sample.starter.repository;

import com.sample.starter.ds.Vendor;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface  VendorRepository extends CrudRepository<Vendor,Long> {
    @Query(value = "SELECT * FROM vendor  WHERE username = :username",nativeQuery=true)
    List<Vendor> findUserByStatusNative(@Param("username") String username);
}