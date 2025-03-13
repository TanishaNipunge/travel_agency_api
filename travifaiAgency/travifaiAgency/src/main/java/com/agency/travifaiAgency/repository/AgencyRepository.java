package com.agency.travifaiAgency.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agency.travifaiAgency.model.Agency;

@Repository
public interface AgencyRepository extends MongoRepository<Agency, String>{
    
}
