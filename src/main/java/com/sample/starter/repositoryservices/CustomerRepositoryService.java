package com.sample.starter.repositoryservices;

import java.util.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import com.sample.starter.ds.*;
import com.sample.starter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerRepositoryService {

    @Autowired
    private final CustomerRepository customerRepository;
    

    public void Create(Customer customer) {
        customerRepository.save(customer);
    }
    public Customer Read(String userName) {
        try{
            List<Customer> customer = (List<Customer>)customerRepository.findUserByStatusNative(userName);
            if(customer.size()!=0)
                return customer.get(0);
            return null;
        }
        catch(NullPointerException e)
        {
            return null;
        }        
    }
    public void Update(Customer customer) {

    }
    public void Delete(Customer customer) {

    }
}