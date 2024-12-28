package com.julian.java_challenge.postcodes_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.julian.java_challenge.postcodes_service.model.Postcode;

public interface PostcodeRepository extends MongoRepository<Postcode, String> {

}
