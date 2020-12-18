package com.sample.starter.services;

import java.time.LocalDate;
import java.util.List;

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
@AllArgsConstructor
public class OrderService {
    
    @Autowired
    private OrderRepositoryService orderRepositoryService;
        
    public void CreateOrder(Order order) {
        orderRepositoryService.Create(order); 

    }

    

    public boolean findOrder(Integer service_id,LocalDate localDate) {
        List<Order> order = orderRepositoryService.Read(service_id);
        for(int i = 0 ; i < order.size();i++)
        {
            if(order.get(i).getDate()==localDate)
                return false;            
        }
        return true;
    }

}