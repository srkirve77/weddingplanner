package com.sample.starter.repositoryservices;

import com.sample.starter.ds.*;
import java.util.*;
import com.sample.starter.ds.*;
import com.sample.starter.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class VenueRepositoryService {

    @Autowired
    private final VenueRepository venueRepository;

    public void Create(Venue venue) {
        venueRepository.save(venue);
    }
    
    public Venue Read(String venueId){
        return null;

    }
    
    public void Update(Venue venue){

    }

    public void Delete(Venue venue){
        
    }
}