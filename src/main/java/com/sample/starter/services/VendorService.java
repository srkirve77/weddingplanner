package com.sample.starter.services;

import com.sample.starter.ds.*;
import com.sample.starter.exchanges.*;
import com.sample.starter.repositoryservices.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;

@Service
public class VendorService {
    @Autowired
    private VendorRepositoryService vendorRepositoryService;

    public boolean SignUp(Vendor vendor) {
        Vendor vendorCheck = vendorRepositoryService.Read(vendor.getUserName());
        if(vendorCheck==null)
        {
                vendorRepositoryService.Create(vendor);
                return true;
        }
        else{
                return false;
        }
    }

    public boolean SignIn(GetVendorRequest getVendorRequest) {
        Vendor vendor = vendorRepositoryService.Read(getVendorRequest.getUserName());
        String password = getVendorRequest.getPassWord();
        if(vendor==null)
            return false;
        if(password.equals(vendor.getPassWord()))
        {
            vendor.setLoggedIn(true);
            return true;
        }
        else
            return false;
    }

    public void SignOut(Vendor vendor) {
        vendor.setLoggedIn(false);
    }

    public void UpdateInfo(Vendor vendor) {
        
    }

    public Vendor findVendor(String userName) {
        Vendor vendor = vendorRepositoryService.Read(userName);
        if(vendor==null)
            return null;
        if(vendor.getUserLoggedIn())
            return vendor;
        else
            return null;
    }

}