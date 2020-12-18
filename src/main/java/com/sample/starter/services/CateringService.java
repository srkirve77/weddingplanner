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

@AllArgsConstructor
@Service
public class CateringService {

    @Autowired
    private final CateringRepositoryService cateringRepositoryService;

    public void CateringRegistration(Catering catering) {
        cateringRepositoryService.Create(catering);
    }

    public Catering findCatering(Integer cateringId) {
        Catering catering = cateringRepositoryService.Read(cateringId);
        try{
            return catering;
        }
        catch(NullPointerException e) {
            return null;
        }

    }
}