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
public class OrderRepositoryService {
    
    @Autowired
    private final OrderRepository orderRepository;
    
    public void Create(Order order) {

    }
    public List<Order> Read(Integer service_id){
        try{
            List<Order> order = (List<Order>)orderRepository.findUserByStatusNative(service_id);
            if(order.size()!=0)
                return order;            
        }
        catch(NullPointerException e)
        {
            return null;
        }    
        return null;

    }
    public void Update(Order order){

    }
    public void Delete(Order order){
        
    }
}