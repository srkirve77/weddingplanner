package com.sample.starter.services;

import com.sample.starter.ds.*;
import com.sample.starter.exchanges.GetCustomerRequest;
import com.sample.starter.repositoryservices.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
    
    @Autowired
    private CustomerRepositoryService customerRepositoryService;
        
    public boolean SignUp(Customer customer) {
        Customer customerCheck = customerRepositoryService.Read(customer.getUserName());
        System.out.println(customerCheck+" checked");
        if(customerCheck==null)
        {
                customerRepositoryService.Create(customer);
                return true;
        }
        else{
                return false;
        }

    }

    public boolean SignIn(GetCustomerRequest getCustomerRequest) {
        Customer customer = customerRepositoryService.Read(getCustomerRequest.getUserName());
        String password = getCustomerRequest.getPassWord();
        if(customer==null)
            return false;
        if(password.equals(customer.getPassWord()))
        {
            customer.setLoggedIn(true);
            return true;
        }
        else
            return false;
    }

    public void SignOut(Customer customer) {
        customer.setLoggedIn(false);
    }

    public void UpdateInfo(Customer customer) {

    }

    public Customer findCustomer(String userName) {
        Customer customer = customerRepositoryService.Read(userName);
        if(customer==null)
            return null;
        if(customer.getUserLoggedIn())
            return customer;
        else
            return null;
    }

}