package com.sample.starter.repositoryservices;

import com.sample.starter.ds.*;
import java.util.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import com.sample.starter.ds.*;
import com.sample.starter.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
public class VendorRepositoryService {

    @Autowired
    private final VendorRepository vendorRepository;

    public void Create(Vendor vendor) {
        vendorRepository.save(vendor);
    }
    public Vendor Read(String userName){
        try{
            List<Vendor> vendor = (List<Vendor>)vendorRepository.findUserByStatusNative(userName);
            if(vendor.size()!=0)
                return vendor.get(0);
            return null;
        }
        catch(NullPointerException e)
        {
            return null;
        }
    }
    public void Update(Vendor vendor){

    }
    public void Delete(Vendor vendor){

    }
}