package com.sample.starter.repositoryservices;


import com.sample.starter.ds.*;
import java.util.*;
import com.sample.starter.ds.*;
import com.sample.starter.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Service
public class CateringRepositoryService {
    
    @Autowired
    private final CateringRepository cateringRepository;
    
    public void Create(Catering catering) {
        cateringRepository.save(catering);
    }
    public Catering Read(Integer cateringId){        
        try{
            List<Catering> catering = (List<Catering>)cateringRepository.findUserByStatusNative(cateringId);
            if(catering.size()!=0)
                return catering.get(0);
            return null;
        }
        catch(NullPointerException e)
        {
            return null;
        }        
    }
    public void Update(Catering catering){

    }
    public void Delete(String userName){
        //Catering catering = cateringRepository.deleteByUserName(userName);
    }
}